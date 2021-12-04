package com.borman.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
public class AuthenticationResponse {
    private String authenticationToken;
    private String username;
    private Instant expiresAt;
    private String refreshToken;
}
