package com.example.demo.springDataJpa.dao;

import com.example.demo.springDataJpa.entity.Customer;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/*第一个泛型是实体类,第二个接口是主键类型*/
public interface CustomerRepository extends JpaRepository<Customer,Long> ,JpaSpecificationExecutor<Customer>{

}
