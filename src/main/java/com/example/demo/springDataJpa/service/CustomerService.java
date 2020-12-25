package com.example.demo.springDataJpa.service;

import com.example.demo.springDataJpa.dao.CustomerRepository;
import com.example.demo.springDataJpa.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

public interface CustomerService {
    Customer saveCustomer(Customer Customer);
    void deleteCustomer(Long id);
    Customer updateCustomer(Customer Customer);
    Customer findCustomer(Long id);
    List findAll();
}
