package com.example.demo.student;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class SaveStudent {
    public static void main(String[] args) {
        EntityManager em = JpaUtils.getEntityManager();

        em.getTransaction().begin();

        Student s = new Student();
        s.setS_id(1001);
        s.setS_age(26);
        s.setS_name("max");
//        将尸体保存到表中
        em.persist(s);
//提交事务
        em.getTransaction().commit();

        em.close();

        System.out.println("All job done.");//原文出自【易百教程】，商业转载请联系作者获得授权，非商业请保留原文链接：https://www.yiibai.com/jpa/jpa-inserting-an-entity.html#article-start


    }
}
