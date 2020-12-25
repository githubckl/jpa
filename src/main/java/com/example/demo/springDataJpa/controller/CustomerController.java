package com.example.demo.springDataJpa.controller;

import com.example.demo.springDataJpa.dao.CustomerRepository;
import com.example.demo.springDataJpa.entity.Customer;
import com.example.demo.springDataJpa.service.CustomerService;
import com.example.demo.springDataJpa.service.impl.CustomerImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("customer")
public class CustomerController {
    @Autowired
    CustomerImpl customerRepository;
    @GetMapping("findAll")
    public List findALl(){
        return customerRepository.findAll();
    }
    @GetMapping("save")
    public Customer save(){
        Customer cUstomer=new Customer();
        cUstomer.setCustId(33l);
        cUstomer.setCustName("ckl1");
        return customerRepository.saveCustomer(cUstomer);
    }@GetMapping("update")
    public Customer update(){
        Customer cUstomer=new Customer();
        cUstomer.setCustId(1l);
        cUstomer.setCustName("lkc");
        return customerRepository.updateCustomer(cUstomer);
    }@GetMapping("findOne")
    public Customer findOne(){
        return customerRepository.findCustomer(1l);
    }
    @GetMapping("delete")
    public void deleteOne(){
        customerRepository.deleteCustomer(1l);
    }


}