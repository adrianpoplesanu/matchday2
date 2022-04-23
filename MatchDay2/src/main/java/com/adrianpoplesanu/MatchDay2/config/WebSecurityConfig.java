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
            .antMatchers("/login", "/bootstrap4.4.1.min.css").permitAll()
            .anyRequest().authenticated()
            .and()
            .oauth2Login()
            .loginPage("/login")
            .successHandler(new AuthenticationSuccessHandler() {
                @Override
                public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
                    System.out.println("onAuthenticationSuccess invoked");
                    System.out.println("Authentication name: " + authentication.getPrincipal().toString());
                    //userService.processOauth2PostLogin(authentication.getPrincipal().toString());
                    DefaultOAuth2User user = (DefaultOAuth2User) authentication.getPrincipal();
                    String sub = user.getAttribute("sub").toString();
                    String name = user.getAttribute("name").toString();
                    String firstName = user.getAttribute("given_name").toString();
                    String lastName = user.getAttribute("family_name").toString();
                    String picture = user.getAttribute("picture").toString();
                    String email = user.getAttribute("email").toString();
                    String email_verified = user.getAttribute("email_verified").toString();
                    String locale = user.getAttribute("locale").toString();
                    userService.processOauth2PostLogin(sub, name, firstName, lastName, picture, email, email_verified, locale);
                    response.sendRedirect("/");
                }
            });
    }
}
