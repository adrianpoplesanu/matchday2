package com.adrianpoplesanu.MatchDay2.controller;

import com.adrianpoplesanu.MatchDay2.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.core.user.DefaultOAuth2User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping(value = "/info", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    String userInfo(Authentication authentication) {
        DefaultOAuth2User oAuth2User = (DefaultOAuth2User) authentication.getPrincipal();

        String googleId = oAuth2User.getAttribute("sub").toString();
        String name = oAuth2User.getAttribute("name").toString();
        String firstName = oAuth2User.getAttribute("given_name").toString();
        String lastName = oAuth2User.getAttribute("family_name").toString();
        String picture = oAuth2User.getAttribute("picture").toString();
        String email = oAuth2User.getAttribute("email").toString();
        String email_verified = oAuth2User.getAttribute("email_verified").toString();
        String locale = oAuth2User.getAttribute("locale").toString();

        return "{\"googleId\": \"" + googleId + "\", " +
                "\"name\": \"" + name + "\", " +
                "\"firstName\": \"" + firstName + "\", " +
                "\"lastName\": \"" + lastName + "\", " +
                "\"picture\": \"" + picture + "\", " +
                "\"email\": \"" + email + "\", " +
                "\"email_verified\": \"" + email_verified + "\", " +
                "\"locale\": \"" + locale + "\", " +
                "\"raw\": \"" + authentication.getPrincipal().toString() +"\"}";
    }
}
