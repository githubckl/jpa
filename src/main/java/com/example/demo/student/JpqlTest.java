package com.example.demo.student;

import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import java.util.List;

public class JpqlTest {
    /*jpql查询全部:from 对象*/
    @Test
    public void selectAll() {
        EntityManager entityManager = JpaUtils.getEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();
        String jpql = "from com.example.demo.student.Student";
        Query query = entityManager.createQuery(jpql);
        List resultList = query.getResultList();
        entityTransaction.commit();
        System.out.println(resultList);
        entityManager.close();
    }

    /*分页: 查询全部后的query对象分别设置firstResult和maxResult*/
    @Test
    public void pagination() {
        EntityManager entityManager = JpaUtils.getEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();
        String jpql = "from com.example.demo.student.Student";
        Query query = entityManager.createQuery(jpql);
//        跳过前1条
        query.setFirstResult(1);
//        从第一条后面取两条
        query.setMaxResults(2);
        List resultList = query.getResultList();
        entityTransaction.commit();
        System.out.println(resultList);
        entityManager.close();
    }

    /*统计个数 select count(字段名)from 对象名,=>Object singleResult*/
    @Test
    public void statistic() {
        EntityManager entityManager = JpaUtils.getEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();
        String jpql = "select count(s_id)from com.example.demo.student.Student ";
        Query query = entityManager.createQuery(jpql);
        Object singleResult = query.getSingleResult();
        entityTransaction.commit();
        entityManager.close();
    }

    /*jpql排序:from 实体类对象 order by 字段 desc/asc*/
    @Test
    public void orderSort() {
        EntityManager entityManager = JpaUtils.getEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();
        String jpql = "from com.example.demo.student.Student order by s_age desc";
        Query query = entityManager.createQuery(jpql);
        List resultList = query.getResultList();
        entityTransaction.commit();
        System.out.println(resultList);
        entityManager.close();
    }

    /*一个条件参数,?1再setParameter*/
    @Test
    public void conditions1() {
        EntityManager entityManager = JpaUtils.getEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();
        String jpql = "from com.example.demo.student.Student where s_name like ?1";
        Query query = entityManager.createQuery(jpql);
        query.setParameter(1, "%a%");
        List resultList = query.getResultList();
        entityTransaction.commit();
        System.out.println(resultList);
        entityManager.close();
    }

    @Test
//    两个条件参数,?1 ?2 再setParameter
    public void conditions2() {
        EntityManager entityManager = JpaUtils.getEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();
        String jpql = "from com.example.demo.student.Student where s_age between ?1 and ?2";
        Query query = entityManager.createQuery(jpql);
        query.setParameter(1, 24);
        query.setParameter(2, 25);

        List resultList = query.getResultList();
        entityTransaction.commit();
        System.out.println(resultList);
        entityManager.close();
    }
}
