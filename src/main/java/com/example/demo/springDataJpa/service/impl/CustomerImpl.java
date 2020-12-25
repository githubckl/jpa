package com.example.demo.springDataJpa.service.impl;

import com.example.demo.springDataJpa.dao.CustomerRepository;
import com.example.demo.springDataJpa.entity.Customer;
import com.example.demo.springDataJpa.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class CustomerImpl implements CustomerService {
    @Autowired
    private CustomerRepository CustomerRepository;
    @Override
    public Customer saveCustomer(Customer Customer) {
        Customer Customer1 =  CustomerRepository.save(Customer);
        return Customer1;
    }



    @Override
    public void deleteCustomer(Long id) {
        CustomerRepository.deleteById(id);
    }

    @Override
    public Customer updateCustomer(Customer Customer) {

        return CustomerRepository.save(Customer);
    }

    @Override
    public Customer findCustomer(Long id) {
        return CustomerRepository.findById(id).get();
    }

    @Override
    public List findAll() {
        return CustomerRepository.findAll();
    }





}
