package com.borman.dto;

import com.borman.entity.User;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class UserCreationDTO {

    private String email;
    private String password;
    private String nickname;

    public User userDtoToUser(UserCreationDTO userDTO) {
        User user = new User();
        user.setEmail(userDTO.getEmail());
        user.setNickname(userDTO.getNickname());
        user.setPassword(userDTO.getPassword());
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
