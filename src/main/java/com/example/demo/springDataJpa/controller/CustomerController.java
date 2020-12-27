package com.example.demo.springDataJpa.controller;

import com.example.demo.springDataJpa.entity.Customer;
import com.example.demo.springDataJpa.entity.LinkMan;
import com.example.demo.springDataJpa.service.impl.CustomerImpl;
import com.example.demo.springDataJpa.service.impl.LinkManImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.test.annotation.Rollback;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;
import java.util.List;

@RestController
@RequestMapping("customer")
public class CustomerController {
    @Autowired
    CustomerImpl customerRepository;
    @Autowired
    LinkManImpl linkManRepository;

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
    }

    @GetMapping("specification4")
    public List specification4() {
        return customerRepository.findAllSort();
    }

    @GetMapping("specification5")
    public Page<Customer> specification5() {
        return customerRepository.findAllPageAndSort();
    }

    /*保存一对多的两个表的数据*/
    @GetMapping("foreignKey")
    @Transactional
    @Rollback(value = false)
    public void foreignKeySave() {
        Customer customer = new Customer();
        customer.setCustName("客户");
        LinkMan linkMan = new LinkMan();
        linkMan.setLkmName("联系人");
        customer.getLinkManSet().add(linkMan);
        customerRepository.saveCustomer(customer);
        linkManRepository.save(linkMan);
    }

    /*保存多对一的两个表的数据*/
    @GetMapping("foreignKey1")
    @Transactional
    @Rollback(value = false)
    public void foreignKeySave1() {
        Customer customer = new Customer();
        customer.setCustName("客户1");
        LinkMan linkMan = new LinkMan();
        linkMan.setLkmName("联系人1");
        linkMan.setCustomer(customer);
        customerRepository.saveCustomer(customer);
        linkManRepository.save(linkMan);
    }/*保存多对一的两个表的数据*/

    @GetMapping("foreignKey2")
    @Transactional
    @Rollback(value = false)
    public void foreignKeySave2() {
        Customer customer = new Customer();
        customer.setCustName("客户1");
        LinkMan linkMan = new LinkMan();
        linkMan.setLkmName("联系人1");
        linkMan.setCustomer(customer);
        customer.getLinkManSet().add(linkMan);
        customerRepository.saveCustomer(customer);
        linkManRepository.save(linkMan);
    }
/*级联添加,添加主表对象的时候也添加从表对象*/
    @GetMapping("cascadeSave")
    @Transactional
    @Rollback(value = false)
    public void cascadeSave() {
        Customer customer = new Customer();
        customer.setCustName("客户1");
        LinkMan linkMan = new LinkMan();
        linkMan.setLkmName("联系人1");
        linkMan.setCustomer(customer);
        customer.getLinkManSet().add(linkMan);
        customerRepository.saveCustomer(customer);
//        linkManRepository.save(linkMan);
    }
    /*级联删除,删除主表对象时也删除从表对象*/
    @GetMapping("cascadeDelete")
    @Transactional
    @Rollback(value = false)
    public void cascadeDelete() {
        Customer customer = customerRepository.findCustomer(1l);

        customerRepository.deleteCustomer(customer.getCustId());
//        linkManRepository.save(linkMan);
    }
}
