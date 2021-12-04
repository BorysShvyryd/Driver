package com.borman.controller;

import com.borman.dto.AuthenticationResponse;
import com.borman.dto.UserDTO;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @PostMapping("/login")
    public String login(@RequestBody UserDTO userDTO){
//    public AuthenticationResponse login(@RequestBody LoginRequest loginRequest){
//        return authService.login(loginRequest);
        return "login";
    }

    @PostMapping("/signup")
    public String registrationUser(String email) {
        return email;
    }
}
