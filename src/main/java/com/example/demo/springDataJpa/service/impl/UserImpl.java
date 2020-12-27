package com.example.demo.springDataJpa.service.impl;

import com.example.demo.springDataJpa.dao.UserRepository;
import com.example.demo.springDataJpa.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserImpl implements UserService {
    @Autowired
    UserRepository userRepository;
}
