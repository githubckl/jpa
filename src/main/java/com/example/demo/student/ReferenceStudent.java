package com.example.demo.student;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ReferenceStudent {
    public static void main(String args[]) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Student_entity");
        EntityManager em = emf.createEntityManager();
//只有在使用查询结果时getReference才会发送sql语句到mysql,否则不查询
        Student s = em.getReference(Student.class, 1001);

        System.out.println("Student id = " + s.getS_id());
        System.out.println("Student Name = " + s.getS_name());
        System.out.println("Student Age = " + s.getS_age());

    }//原文出自【易百教程】，商业转载请联系作者获得授权，非商业请保留原文链接：https://www.yiibai.com/jpa/jpa-finding-an-entity.html#article-start

}
