package com.borman.service;

import com.borman.entity.Role;
import com.borman.repository.RoleRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class RoleService {

    private final RoleRepository roleRepository;


    public Role getRoleAdmin() {
        return roleRepository.getByName("ROLE_ADMIN");
    }

    public Role getRoleUser() {
        return roleRepository.getByName("ROLE_USER");
    }

}
