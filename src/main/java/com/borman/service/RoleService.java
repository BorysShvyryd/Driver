package com.borman.service;

import com.borman.entity.Role;
import com.borman.repository.RoleRepository;
import org.springframework.stereotype.Service;

@Service
public class RoleService {

    private final RoleRepository roleRepository;

    public RoleService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    public Role getRoleAdmin() {
        return roleRepository.getByName("ROLE_ADMIN");
    }

    public Role getRoleUser() {
        return roleRepository.getByName("ROLE_USER");
    }

}
