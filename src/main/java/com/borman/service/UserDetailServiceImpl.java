//package com.borman.service;
//
//import com.borman.entity.User;
//import lombok.AllArgsConstructor;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
//import java.util.Arrays;
//
//@Service
//@AllArgsConstructor
//public class UserDetailServiceImpl implements UserDetailsService {
//
//    private final UserService userService;
//
//
//    @Override
//    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
//        User user = userService.findUserByEmail(email);
////                .orElseThrow(() -> new RuntimeException("User not found: " + username));
//
//        if (user == null) {throw new UsernameNotFoundException(email); }
//
//        return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), user.getRoles());
//    }
//}
