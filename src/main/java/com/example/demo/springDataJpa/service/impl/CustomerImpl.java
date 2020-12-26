package com.example.demo.springDataJpa.service.impl;

import com.example.demo.springDataJpa.dao.CustomerRepository;
import com.example.demo.springDataJpa.entity.Customer;
import com.example.demo.springDataJpa.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service

public class CustomerImpl implements CustomerService {
    @Autowired
    private CustomerRepository customerRepository;
    @Override
    public Customer saveCustomer(Customer Customer) {
        Customer Customer1 =  customerRepository.save(Customer);
        return Customer1;
    }



    @Override
    public void deleteCustomer(Long id) {
        customerRepository.deleteById(id);
    }

    @Override
    public Customer updateCustomer(Customer Customer) {

        return customerRepository.save(Customer);
    }

    @Override
    public Customer findCustomer(Long id) {
        return customerRepository.findById(id).get();
    }

    @Override
    public List findAll() {
        return customerRepository.findAll();
    }

    @Override
    public long count() {
        return customerRepository.count();
    }

    @Override
    public boolean exists(long id) {
        return customerRepository.existsById(id);
    }

    @Override
    @Transactional
    public Customer getOne(long id) {
        return customerRepository.getOne(id);
    }

    @Override
    public List jpql(String custName) {
        return customerRepository.jpql(custName);
    }

    @Override
    public List jpql2(String custName, long custId) {
        return customerRepository.jpql2(custName,custId);
    }

    @Override
    public void jpqlUpdate(String custName, long custId) {
        customerRepository.jpqlUpdate(custName,custId);
    }

    @Override
    public List sql(String cust_name) {
        return customerRepository.sql(cust_name);
    }
    public List findByCustName(String cust_name){
        return customerRepository.findByCustName(cust_name);
    }

    @Override
    public List findByCustIdBetween(long id1, long id2) {
        return customerRepository.findByCustIdBetween(id1,id2);
    }
    public List findByCustNameLikeAndCustId(String custName,long id){
        return customerRepository.findByCustNameLikeAndCustId(custName,id);
    }

}
