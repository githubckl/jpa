package com.example.demo.student;
import javax.persistence.*;
//原文出自【易百教程】，商业转载请联系作者获得授权，非商业请保留原文链接：https://www.yiibai.com/jpa/jpa-deleting-an-entity.html#article-start


public class DeleteStudent {
    public static void main(String args[]) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Student");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
//根据主键找到要删除的对象,然后用remove直接删除
        Student s = em.find(Student.class, 1001);
        em.remove(s);
        em.getTransaction().commit();
        em.close();
        emf.close();

    }//原文出自【易百教程】，商业转载请联系作者获得授权，非商业请保留原文链接：https://www.yiibai.com/jpa/jpa-deleting-an-entity.html#article-start


}
