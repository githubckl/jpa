package com.example.demo.student;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JpaUtils {
    private  static EntityManagerFactory factory;
    static{
        factory=Persistence.createEntityManagerFactory("Student_entity");
    }
    public static EntityManager getEntityManager(){
        return factory.createEntityManager();
    }
}
