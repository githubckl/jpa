package com.example.demo.student;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class UpdateStudent {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Student_entity");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
//先利用find和主键来找到要修改的记录
        Student s = em.find(Student.class, 1001);
        System.out.println("Before Updation");
        System.out.println("Student id = " + s.getS_id());
        System.out.println("Student Name = " + s.getS_name());
        System.out.println("Student Age = " + s.getS_age());
//再对实体进行修改
        s.setS_age(30);
        em.merge(s);
        em.getTransaction().commit();
         em.close();
        emf.close();
        Student new_s=em.find(Student.class,1001);
        System.out.println(new_s.getS_age());
        System.out.println("After Updation");
        System.out.println("Student id = " + new_s.getS_id());
        System.out.println("Student Name = " + new_s.getS_name());
        System.out.println("Student Age = " + new_s.getS_age());//原文出自【易百教程】，商业转载请联系作者获得授权，非商业请保留原文链接：https://www.yiibai.com/jpa/jpa-updating-an-entity.html#article-start


    }
}
