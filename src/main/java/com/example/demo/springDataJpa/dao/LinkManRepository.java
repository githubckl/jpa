package com.example.demo.springDataJpa.dao;

import com.example.demo.springDataJpa.entity.LinkMan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface LinkManRepository extends JpaRepository<LinkMan,Long>, JpaSpecificationExecutor<LinkMan> {
}
