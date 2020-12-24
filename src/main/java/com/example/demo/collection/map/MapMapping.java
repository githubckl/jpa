package com.example.demo.collection.map;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class MapMapping {
    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Collection_Type");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        Address a1 = new Address();
        a1.setE_pincode(511000);
        a1.setE_city("Guangzhou");
        a1.setE_state("Guangdong");

        Address a2 = new Address();
        a2.setE_pincode(202001);
        a2.setE_city("Nanjing");
        a2.setE_state("Jiangsu");

        Address a3 = new Address();
        a3.setE_pincode(333301);
        a3.setE_city("Chengdu");
        a3.setE_state("Shichuan");

        Address a4 = new Address();
        a4.setE_pincode(80001);
        a4.setE_city("Haikou");
        a4.setE_state("Hainan");

        Employee2 e1 = new Employee2();
        e1.setE_id(1);
        e1.setE_name("Maxsu");

        Employee2 e2 = new Employee2();
        e2.setE_id(2);
        e2.setE_name("Leeze");

        Employee2 e3 = new Employee2();
        e3.setE_id(3);
        e3.setE_name("William");

        Employee2 e4 = new Employee2();
        e4.setE_id(4);
        e4.setE_name("Curry");

        e1.getMap().put(1, a1);
        e2.getMap().put(2, a2);
        e3.getMap().put(3, a3);
        e4.getMap().put(4, a4);

        em.persist(e1);
        em.persist(e2);
        em.persist(e3);
        em.persist(e4);

        em.getTransaction().commit();

        em.close();
        emf.close();
//原文出自【易百教程】，商业转载请联系作者获得授权，非商业请保留原文链接：https://www.yiibai.com/jpa/jpa-map-mapping.html#article-start


    }
}