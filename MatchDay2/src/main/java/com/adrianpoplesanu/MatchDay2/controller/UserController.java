package com.adrianpoplesanu.MatchDay2.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@RequestMapping(value = "/user")
public class UserController {
    @GetMapping(value = "/info")
    @ResponseBody
    String userInfo(Principal principal) {
        return principal.toString();
    }
}
