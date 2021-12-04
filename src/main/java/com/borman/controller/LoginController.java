package com.borman.controller;

import com.borman.dto.AuthenticationResponse;
import com.borman.dto.LoginRequest;
import com.borman.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
@AllArgsConstructor
public class LoginController {

    private final UserService userService;

    @PostMapping
    public AuthenticationResponse login(@RequestBody LoginRequest loginRequest){
//        return authService.login(loginRequest);
        return new AuthenticationResponse();
    }
}
