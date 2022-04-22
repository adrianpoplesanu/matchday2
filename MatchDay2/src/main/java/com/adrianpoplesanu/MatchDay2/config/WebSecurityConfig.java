package com.adrianpoplesanu.MatchDay2.config;

import com.adrianpoplesanu.MatchDay2.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.core.user.DefaultOAuth2User;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    UserService userService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
            .authorizeRequests()
            .antMatchers("/login").permitAll()
            .anyRequest().authenticated()
            .and()
            .oauth2Login()
            .loginPage("/login")
            .successHandler(new AuthenticationSuccessHandler() {
                @Override
                public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
                    System.out.println("onAuthenticationSuccess invoked");
                    System.out.println("Authentication name: " + authentication.getPrincipal().toString());
                    userService.processOauth2PostLogin(authentication.getPrincipal().toString());
                    DefaultOAuth2User user = (DefaultOAuth2User) authentication.getPrincipal();
                    System.out.println(user.getAttribute("sub").toString());
                    System.out.println(user.getAttribute("name").toString());
                    System.out.println(user.getAttribute("given_name").toString());
                    System.out.println(user.getAttribute("family_name").toString());
                    System.out.println(user.getAttribute("picture").toString());
                    System.out.println(user.getAttribute("email").toString());
                    System.out.println(user.getAttribute("email_verified").toString());
                    System.out.println(user.getAttribute("locale").toString());
                    response.sendRedirect("/");
                }
            });
    }
}
