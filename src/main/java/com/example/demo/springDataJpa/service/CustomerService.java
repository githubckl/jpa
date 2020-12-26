package com.example.demo.springDataJpa.service;

import com.example.demo.springDataJpa.entity.Customer;
import org.springframework.data.domain.Page;

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

    public List jpql(String custName);

    public List jpql2(String custName, long custId);

    public void jpqlUpdate(String custName, long custId);

    public List sql(String cust_name);

    public List findByCustName(String cust_name);

    public List findByCustIdBetween(long id1, long id2);

    public List findByCustNameLikeAndCustId(String custName, long id);

    public Customer findOne();

    public Customer findOne2();
    public List findAllSpec();
    public List findAllSort();public Page<Customer> findAllPageAndSort();
}
