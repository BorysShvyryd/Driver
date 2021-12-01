package com.borman.service;

import com.borman.entity.User;

public interface UserService {

    public User findUserByEmail(String email);

    public User findUserById(Long id);

    public void saveUser(User user);

    public void updateUser(User user);

    public void changePassUser(User user);

    public void deleteUser(User user);
}