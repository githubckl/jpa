package com.example.demo.springDataJpa.service;

import com.example.demo.springDataJpa.entity.Customer;

import java.util.List;

public interface CustomerService {
    Customer saveCustomer(Customer Customer);
    void deleteCustomer(Long id);
    Customer updateCustomer(Customer Customer);
    Customer findCustomer(Long id);
    List findAll();
    long count();
    boolean exists(long id);
    Customer getOne(long id);
}
