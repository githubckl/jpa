package com.example.demo.student;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
/* 实体管理器工厂的创建非常耗费资源,但是线程安全的,因此在这里做成静态的唯一对象,使它的创建只有一次却可以服务多次*/
public class JpaUtils {
    private  static EntityManagerFactory factory;
    static{
        factory=Persistence.createEntityManagerFactory("Student");
    }
    public static EntityManager getEntityManager(){
        return factory.createEntityManager();
    }
}
