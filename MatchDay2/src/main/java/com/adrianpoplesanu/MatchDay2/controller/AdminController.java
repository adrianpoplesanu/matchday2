package com.adrianpoplesanu.MatchDay2.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/admin")
public class AdminController {
    @PutMapping("/add-comptition")
    public String addCompetition() {
        return null;
    }

    @PostMapping("/activate-competition")
    public String activateCompetition() {
        return null;
    }

    @PostMapping("/deactivate-competition")
    public String deactivateCompetition() {
        return null;
    }

    @PostMapping("/change-user-status")
    public String changeUserStatus() {
        return null;
    }
}
