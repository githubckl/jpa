package com.example.demo.springDataJpa.test;

import com.example.demo.springDataJpa.dao.CustomerRepository;
import com.example.demo.springDataJpa.entity.Customer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


public class TestCustomer {
    @Autowired
    private CustomerRepository repository;

    @Test
    public void testSave() {
        Customer customer = new Customer();
        customer.setCustAddress("123");
        Customer save = repository.save(customer);
        System.out.println(save);
    }

    @Test
    public void testDelete() {

    }

    @Test
    public void testUpdate() {

    }

    @Test
    public void testSelect() {
        repository.findAll();
    }
}
