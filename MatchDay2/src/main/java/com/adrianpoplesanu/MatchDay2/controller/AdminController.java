package com.adrianpoplesanu.MatchDay2.controller;

import com.adrianpoplesanu.MatchDay2.model.Competition;
import com.adrianpoplesanu.MatchDay2.model.User;
import com.adrianpoplesanu.MatchDay2.service.CompetitionService;
import com.adrianpoplesanu.MatchDay2.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/admin")
public class AdminController {

    @Autowired
    UserService userService;

    @Autowired
    CompetitionService competitionService;

    @GetMapping("/competitions")
    public List<Competition> getAllCompetitions() {
        return competitionService.getAllCompetitions();
    }

    @PutMapping("/competition")
    public String addCompetition() {
        return "bebe dec e latrutz";
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

    @GetMapping("/users")
    public List<User> getAllUsers() {
        List<User> users = userService.getAllUsers();
        return users;
    }

    @PutMapping("/user")
    public User updateUser() {
        return null;
    }
}
