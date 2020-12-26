package com.example.demo.springDataJpa.controller;

import com.example.demo.springDataJpa.entity.Customer;
import com.example.demo.springDataJpa.service.impl.CustomerImpl;
import org.springframework.beans.factory.annotation.Autowired;
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
    public List findALl() {
        return customerRepository.findAll();
    }

    @GetMapping("save")
    public Customer save() {
        Customer cUstomer = new Customer();
        cUstomer.setCustId(33l);
        cUstomer.setCustName("ckl1");
        return customerRepository.saveCustomer(cUstomer);
    }

    @GetMapping("update")
    public Customer update() {
        Customer cUstomer = new Customer();
        cUstomer.setCustId(1l);
        cUstomer.setCustName("lkc");
        return customerRepository.updateCustomer(cUstomer);
    }

    @GetMapping("findOne")
    public Customer findOne() {
        return customerRepository.findCustomer(1l);
    }

    @GetMapping("delete")
    public void deleteOne() {
        customerRepository.deleteCustomer(1l);
    }

    @GetMapping("count")
    public long count() {
        return customerRepository.count();
    }

    @GetMapping("exist")
    public boolean exist() {
        return customerRepository.exists(4);
    }

    /*findOne和getOne
     * 前者是通过jpa的find,后者是通过jpa的getReference,后者懒加载*/
    @GetMapping("getOne")
    public Customer getOne() {
        return customerRepository.getOne(3);
    }

    @GetMapping("jpql")
    public List jpql() {
        return customerRepository.jpql("ckl1");
    }

    @GetMapping("jpql2")
    public List jpql2() {
        return customerRepository.jpql2("ckl1", 1);
    }

    @GetMapping("jpqlUpdate")
    public void jpqlUpdate(String custName, long custId) {
        customerRepository.jpqlUpdate(custName, custId);
    }

    @GetMapping("sql")
    public List sql(String cust_name) {
        return customerRepository.sql(cust_name);
    }

    /*方法名称规则查询*/
    @GetMapping("findByCustName")
    public List findByCustName(String cust_name) {
        return customerRepository.findByCustName(cust_name);
    }

    /*方法名称规则复杂查询*/
    @GetMapping("findByCustIdBetween")
    public List findByCustIdBetween(long id1, long id2) {
        return customerRepository.findByCustIdBetween(id1, id2);
    }

    @GetMapping("findByCustNameAndCustId")
    public List findByCustNameLikeAndCustId(String custName, long id) {
        return customerRepository.findByCustNameLikeAndCustId("%" + custName + "%", id);
    }

    @GetMapping("specification")
    public Customer specification() {
        return customerRepository.findOne();
    }

    @GetMapping("specification2")
    public Customer specification2() {
        return customerRepository.findOne2();
    }

    @GetMapping("specification3")
    public List specification3() {
        return customerRepository.findAllSpec();
    }@GetMapping("specification4")
    public List specification4() {
        return customerRepository.findAllSort();
    }
}
