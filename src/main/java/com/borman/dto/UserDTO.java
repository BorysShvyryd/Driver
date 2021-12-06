package com.borman.dto;

import com.borman.entity.Role;
import com.borman.entity.User;
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

    public User userDTOToUser(UserDTO userDTO) {
        User user = new User();
        user.setEmail(userDTO.getEmail());
        user.setNickname(userDTO.getNickname());
        user.setRoles(userDTO.getRoles());
        user.setEnabled(userDTO.getEnabled());
        user.setNumberOfPoints(userDTO.getNumberOfPoints());
        return user;
    }

    public UserDTO UserToUserDto(User user) {
        return UserDTO.builder()
                .email(user.getEmail())
                .nickname(user.getNickname())
                .roles(user.getRoles())
                .enabled(user.getEnabled())
                .numberOfPoints(user.getNumberOfPoints())
                .build();
    }
}
