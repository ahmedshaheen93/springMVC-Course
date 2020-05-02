/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shaheen.repository;


import com.shaheen.config.ConnectionToDB;

import javax.persistence.EntityManager;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

/**
 * @author lts
 */
public abstract class CrudImpl<T, R> implements Crud<T, R> {

    private final EntityManager entityManager = ConnectionToDB.getInstance().getEntityManager();

    private final String typeName = getTypeName();

    @Override
    public List<T> findAll() {
        return (List<T>) entityManager.createQuery("from " + typeName).getResultList();
    }

    @Override
    public T findById(R id) {
        try {
            return (T) entityManager.find(Class.forName(typeName), id);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public T update(T t) {
        entityManager.getTransaction().begin();
        entityManager.merge(t);
        entityManager.getTransaction().commit();
        return t;
    }

    @Override
    public T save(T t) {
        entityManager.getTransaction().begin();
        entityManager.persist(t);
        entityManager.getTransaction().commit();
        return t;
    }

    @Override
    public void delete(T t) {
        entityManager.getTransaction().begin();
        entityManager.remove(t);
        entityManager.getTransaction().commit();
    }

    private String getTypeName() {
        try {
            Type sooper = getClass().getGenericSuperclass();
            Type t = ((ParameterizedType) sooper).getActualTypeArguments()[0];
            return t.getTypeName();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public EntityManager getEntityManager() {
        return entityManager;
    }

}
