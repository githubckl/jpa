package com.example.demo.springDataJpa.dao;

import com.example.demo.springDataJpa.entity.LinkMan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface LinkManRepository extends JpaRepository<LinkMan,Long>, JpaSpecificationExecutor<LinkMan> {
//    级联操作:保存一个主表对象时同时保存从表对象,删除主表对象时也删除从表对象
}
