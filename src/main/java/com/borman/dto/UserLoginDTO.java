package com.borman.dto;

import com.borman.entity.User;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class UserLoginDTO {

    private String username;
    private String password;

    public User userLoginDTOToUser(UserLoginDTO userLoginDTO) {
        User user = new User();
        user.setEmail(userLoginDTO.getUsername());
        user.setPassword(userLoginDTO.getPassword());
        return user;
    }
}
