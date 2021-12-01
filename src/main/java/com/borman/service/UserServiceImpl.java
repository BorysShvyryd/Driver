package com.borman.service;

import com.borman.entity.Role;
import com.borman.entity.User;
import com.borman.repository.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;
    private final RoleService roleService;
    private final BCryptPasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository, RoleService roleService, BCryptPasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.roleService = roleService;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public User findUserByEmail(String email) {
        return userRepository.getByEmail(email);
    }

    @Override
    public User findUserById(Long id) {
        return userRepository.getById(id);
    }

    @Override
    public void saveUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setEnabled(1);
        Role userRole = roleService.getRoleUser();
        Set<Role> roles = new HashSet<>();
        roles.add(userRole);
        user.setRoles(roles);
        userRepository.save(user);
    }

    @Override
    public void updateUser(User user) {
        User changeUser = userRepository.getById(user.getId());
        changeUser.setEnabled(user.getEnabled());
        changeUser.setRoles(user.getRoles());
        changeUser.setNickname(user.getNickname());
        changeUser.setNumberOfPoints(user.getNumberOfPoints());
    }

    @Override
    public void changePassUser(User user) {
        User changeUser = userRepository.getById(user.getId());
        changeUser.setPassword(passwordEncoder.encode(user.getPassword()));
    }

    @Override
    public void deleteUser(User user) {
        userRepository.delete(user);
    }
}
