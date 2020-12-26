package com.example.demo.springDataJpa.dao;

import com.example.demo.springDataJpa.entity.Customer;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.test.annotation.Rollback;

import javax.transaction.Transactional;
import java.util.List;

/*第一个泛型是实体类,第二个接口是主键类型*/
public interface CustomerRepository extends JpaRepository<Customer, Long>, JpaSpecificationExecutor<Customer> {
    /**
     * 使用jpql在springdatajpa中查询
     * 根据客户名称查询
     * from Customer where cust_name=?
     */
    @Query(value = "from com.example.demo.springDataJpa.entity.Customer where custName= ?1 ")
    public List jpql(String custName);

    /*jpql使用两个参数查询
     * 参数顺序需要与占位符一致  */
    @Query(value = "from Customer where custName=?1 and custId=?2")
    public List jpql2(String custName, long custId);

    @Query(value = "update Customer set custName=?1 where custId=?2")
    //Modifing声明Query里的语句不是查询
    @Modifying
    @Transactional
//    添加事务后会默认回滚,因此需要下面的注解来取消回滚
    @Rollback(value = false)
    public void jpqlUpdate(String custName, long custId);

    @Query(value = "select * from customer where cust_name like %?1%", nativeQuery = true)
    public List sql(String cust_name);
//方法命名查询,findBy+属性名称+查询方式(like|isnull等等)
public List findByCustName(String cust_name);
    public List findByCustIdBetween(long id1,long id2);
    public List findByCustNameLikeAndCustId(String custName,long id);
}
