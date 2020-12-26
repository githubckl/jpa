package com.example.demo.springDataJpa.service.impl;

import com.example.demo.springDataJpa.dao.CustomerRepository;
import com.example.demo.springDataJpa.entity.Customer;
import com.example.demo.springDataJpa.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.*;
import javax.transaction.Transactional;
import java.util.List;

@Service

public class CustomerImpl implements CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public Customer saveCustomer(Customer Customer) {
        Customer Customer1 = customerRepository.save(Customer);
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
        return customerRepository.jpql2(custName, custId);
    }

    @Override
    public void jpqlUpdate(String custName, long custId) {
        customerRepository.jpqlUpdate(custName, custId);
    }

    @Override
    public List sql(String cust_name) {
        return customerRepository.sql(cust_name);
    }

    public List findByCustName(String cust_name) {
        return customerRepository.findByCustName(cust_name);
    }

    @Override
    public List findByCustIdBetween(long id1, long id2) {
        return customerRepository.findByCustIdBetween(id1, id2);
    }

    public List findByCustNameLikeAndCustId(String custName, long id) {
        return customerRepository.findByCustNameLikeAndCustId(custName, id);
    }

    //用specification构造条件,查找某个名称的客户
    @Override
    public Customer findOne() {
//匿名内部类
        Specification specification = new Specification<Customer>() {
            @Override
            public Predicate toPredicate(Root<Customer> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
//                获取要比较的属性
                Path custName = root.get("custName");
//                给要比较的属性赋值查询
                Predicate ooo = criteriaBuilder.equal(custName, "ooo");
                return ooo;
            }
        };
//        调用findone把条件specification附上去
        return (Customer) customerRepository.findOne(specification).get();
    }

    //specification多条件查询
    @Override
    public Customer findOne2() {
        Specification specification = new Specification<Customer>() {
            @Override
            public Predicate toPredicate(Root<Customer> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                Path<Object> custName = root.get("custName");
                Predicate ooo = criteriaBuilder.equal(custName, "ooo");
                Path<Object> custIndustry = root.get("custIndustry");
                Predicate it = criteriaBuilder.equal(custIndustry, "it");
                Predicate and= criteriaBuilder.and(ooo,it);
//                Predicate and= criteriaBuilder.or(ooo,it);
                return and;
            }
        };
        return (Customer)customerRepository.findOne(specification).get();
    }
    //使用specification得到list结果
    @Override
    public List findAllSpec() {
        Specification<Customer> specification=new Specification<Customer>() {
            @Override
            public Predicate toPredicate(Root<Customer> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                Path<Object> custName = root.get("custName");
//                对于like而言,其比较的对象可能是date,varchar或者int,所以下面要用as来做一个转换
//                对于equal而言,就是直接的path对象
                Predicate like = criteriaBuilder.like(custName.as(String.class), "%o%");
                return like;
            }
        };
        return customerRepository.findAll(specification);
    }//使用specification得到list结果

    @Override
    public List findAllSort() {
        Specification<Customer> specification=new Specification<Customer>() {
            @Override
            public Predicate toPredicate(Root<Customer> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                Path<Object> custName = root.get("custName");
//                对于like而言,其比较的对象可能是date,varchar或者int,所以下面要用as来做一个转换
//                对于equal而言,就是直接的path对象
                Predicate like = criteriaBuilder.like(custName.as(String.class), "%%");
                return like;
            }
        };

        return customerRepository.findAll(specification, Sort.by(Sort.Direction.DESC,"custIndustry"));
    }

    @Override
    public List findAllPage() {
        Specification<Customer> specification=new Specification<Customer>() {
            @Override
            public Predicate toPredicate(Root<Customer> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                Path<Object> custName = root.get("custName");
//                对于like而言,其比较的对象可能是date,varchar或者int,所以下面要用as来做一个转换
//                对于equal而言,就是直接的path对象
                Predicate like = criteriaBuilder.like(custName.as(String.class), "%%");
                return like;
            }
        };

        return customerRepository.findAll(specification, new Pageable() {
        });
    }

}
