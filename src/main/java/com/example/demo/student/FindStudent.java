package com.example.demo.student;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class FindStudent {
    public static void main(String args[]) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Student");
        EntityManager em = emf.createEntityManager();
//find是根据主键来查找实体的,其中类对象提供了表名
        Student s = em.find(Student.class, 1001);

        System.out.println("Student id = " + s.getS_id());
        System.out.println("Student Name = " + s.getS_name());
        System.out.println("Student Age = " + s.getS_age());

    }//原文出自【易百教程】，商业转载请联系作者获得授权，非商业请保留原文链接：https://www.yiibai.com/jpa/jpa-finding-an-entity.html#article-start


}
