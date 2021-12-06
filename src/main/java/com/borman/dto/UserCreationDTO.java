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

    public User userCreationDTOToUser(UserCreationDTO userDTO) {
        User user = new User();
        user.setEmail(userDTO.getEmail());
        user.setNickname(userDTO.getNickname());
        user.setPassword(userDTO.getPassword());
        return user;
    }
}
