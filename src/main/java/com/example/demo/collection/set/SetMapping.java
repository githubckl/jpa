package com.example.demo.collection.set;
import javax.persistence.*;


public class SetMapping {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Collection_Type");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        Address a1 = new Address();
        a1.setE_pincode(501000);
        a1.setE_city("Guangzhou");
        a1.setE_state("GuangDong");

        Address a2 = new Address();
        a2.setE_pincode(571100);
        a2.setE_city("Haikou");
        a2.setE_state("Hainan");

        Address a3 = new Address();
        a3.setE_pincode(533300);
        a3.setE_city("Hangzhou");
        a3.setE_state("Zhejiang");

        Address a4 = new Address();
        a4.setE_pincode(780000);
        a4.setE_city("Nanjing");
        a4.setE_state("Jiangsu");

        Employee1 e1 = new Employee1();
        e1.setE_id(1000);
        e1.setE_name("Maxsu");

        Employee1 e2 = new Employee1();
        e2.setE_id(1002);
        e2.setE_name("Marry");

        Employee1 e3 = new Employee1();
        e3.setE_id(1003);
        e3.setE_name("William");

        Employee1 e4 = new Employee1();
        e4.setE_id(1004);
        e4.setE_name("Curry");

        e1.getAddress().add(a1);
        e2.getAddress().add(a2);
        e3.getAddress().add(a3);
        e4.getAddress().add(a4);

        em.persist(e1);
        em.persist(e2);
        em.persist(e3);
        em.persist(e4);

        em.getTransaction().commit();

        em.close();
        emf.close();

    }

}//原文出自【易百教程】，商业转载请联系作者获得授权，非商业请保留原文链接：https://www.yiibai.com/jpa/jpa-set-mapping.html

