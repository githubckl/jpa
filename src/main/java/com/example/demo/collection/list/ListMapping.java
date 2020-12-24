package com.example.demo.collection.list;
import javax.persistence.*;


public class ListMapping {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Collection_Type");
        EntityManager em = emf.createEntityManager();

        System.out.println("Start work...");
        em.getTransaction().begin();

        Address a1 = new Address();
        a1.setE_pincode(201301);
        a1.setE_city("Guangzhou");
        a1.setE_state("GuangDong");

        Address a2 = new Address();
        a2.setE_pincode(302001);
        a2.setE_city("Haikou");
        a2.setE_state("Hainan");

        Employee e1 = new Employee();
        e1.setE_id(1);
        e1.setE_name("Maxsu");
        e1.getAddress().add(a1);

        Employee e2 = new Employee();
        e2.setE_id(2);
        e2.setE_name("John");
        e2.getAddress().add(a2);

        em.persist(e1);
        em.persist(e2);

        em.getTransaction().commit();

        em.close();
        emf.close();
        System.out.println("End work...");

    }

}//原文出自【易百教程】，商业转载请联系作者获得授权，非商业请保留原文链接：https://www.yiibai.com/jpa/jpa-list-mapping.html#article-start

