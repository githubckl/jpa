package com.example.demo.springDataJpa.service;

import com.example.demo.springDataJpa.entity.User;

public interface UserService {
    void save(User user);
    User findOne(long id);
    void delete(User user);
}
