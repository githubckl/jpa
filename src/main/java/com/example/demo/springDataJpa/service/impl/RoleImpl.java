package com.example.demo.springDataJpa.service.impl;

import com.example.demo.springDataJpa.dao.RoleRepository;
import com.example.demo.springDataJpa.entity.Role;
import com.example.demo.springDataJpa.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleImpl implements RoleService {
    @Autowired
    RoleRepository roleRepository;

    @Override
    public void save(Role role) {
        roleRepository.save(role);
    }
}
