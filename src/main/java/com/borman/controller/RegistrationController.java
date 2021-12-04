package com.borman.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/reg")
public class RegistrationController {

    @PostMapping
    public String registrationUser() {
        return "";
    }
}
