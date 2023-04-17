package com.amir.Diploma.services.impl;

import com.amir.Diploma.models.Role;
import com.amir.Diploma.repositories.RoleRepository;
import com.amir.Diploma.services.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    RoleRepository roleRepository;

    @Override
    public Role getRoleByName(String name) {
        return roleRepository.getRoleByName(name);
    }
}
