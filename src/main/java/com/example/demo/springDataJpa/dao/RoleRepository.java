package com.example.demo.springDataJpa.dao;

import com.example.demo.springDataJpa.entity.Role;
import com.example.demo.springDataJpa.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface RoleRepository extends JpaRepository<Role,Long>, JpaSpecificationExecutor<Role> {
}
