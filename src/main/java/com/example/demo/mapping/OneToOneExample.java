package com.example.demo.mapping;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class OneToOneExample {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Book_issued");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        Students st1 = new Students();
        st1.setS_id(1);
        st1.setS_name("Maxsu");

        Students st2 = new Students();
        st2.setS_id(2);
        st2.setS_name("James");

        em.persist(st1);
        em.persist(st2);

        Library lib1 = new Library();
        lib1.setB_id(101);
        lib1.setB_name("Data Structure");
        lib1.setStud(st1);

        Library lib2 = new Library();
        lib2.setB_id(102);
        lib2.setB_name("DBMS");
        lib2.setStud(st2);

        em.persist(lib1);
        em.persist(lib2);

        em.getTransaction().commit();

        em.close();
        emf.close();//原文出自【易百教程】，商业转载请联系作者获得授权，非商业请保留原文链接：https://www.yiibai.com/jpa/jpa-one-to-one-mapping.html


    }
}
