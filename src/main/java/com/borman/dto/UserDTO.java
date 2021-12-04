package com.borman.dto;

import com.borman.entity.Role;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@Builder
public class UserDTO {

    private String email;
    private String nickname;
    private Set<Role> roles;
    private int enabled;
    private int numberOfPoints;
}
