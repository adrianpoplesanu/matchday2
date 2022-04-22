package com.adrianpoplesanu.MatchDay2.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class StatusController {
    @GetMapping("/status")
    @ResponseBody
    String status() {
        return "buna dimineata";
    }
}
