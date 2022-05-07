package com.adrianpoplesanu.MatchDay2.controller;

import com.adrianpoplesanu.MatchDay2.service.UserService;
import com.adrianpoplesanu.MatchDay2.utils.activation.ActivationManager;
import com.adrianpoplesanu.MatchDay2.utils.activation.ActivationRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.core.user.DefaultOAuth2User;
import org.springframework.web.bind.annotation.*;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    ActivationManager activationManager;

    @GetMapping(value = "/info", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public String userInfo(Authentication authentication) {
        DefaultOAuth2User oAuth2User = (DefaultOAuth2User) authentication.getPrincipal();

        String googleId = oAuth2User.getAttribute("sub").toString();
        String name = oAuth2User.getAttribute("name").toString();
        String firstName = oAuth2User.getAttribute("given_name").toString();
        String lastName = oAuth2User.getAttribute("family_name").toString();
        String picture = oAuth2User.getAttribute("picture").toString();
        String email = oAuth2User.getAttribute("email").toString();
        String email_verified = oAuth2User.getAttribute("email_verified").toString();
        String locale = oAuth2User.getAttribute("locale").toString();

        //User user = userService.getUserByEmail(email);

        return "{\"googleId\": \"" + googleId + "\", " +
                "\"name\": \"" + name + "\", " +
                "\"firstName\": \"" + firstName + "\", " +
                "\"lastName\": \"" + lastName + "\", " +
                "\"picture\": \"" + picture + "\", " +
                "\"email\": \"" + email + "\", " +
                "\"email_verified\": \"" + email_verified + "\", " +
                "\"locale\": \"" + locale + "\", " +
                "\"isActivated\": \"" + userService.isUserActivated(email) + "\", " +
                "\"isAdmin\": \"" + userService.isAdmin(email) + "\", " +
                "\"isActive\": \"" + userService.isActive(email) + "\", " +
                "\"raw\": \"" + authentication.getPrincipal().toString() +"\"}";
    }

    @PostMapping(value = "/activate", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public String activateUser(@RequestBody ActivationRequest activationRequest) {
        if (activationManager.checkCode(activationRequest.getActivationCode())) {
            return "{\"message\": \"activated\"}";
        } else {
            return "{\"message\": \"failed\"}";
        }
    }

    @GetMapping(value = "/test-cron")
    @ResponseBody
    public String testCron() throws IOException {
        System.out.println("buna dimineata !!!");
        String fileName = "/Users/adrianpoplesanu/Documents/test.txt";
        String str = String.valueOf(java.time.LocalDate.now());
        BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
        writer.write(str);
        writer.close();
        return "ala bala portocala";
    }
}
