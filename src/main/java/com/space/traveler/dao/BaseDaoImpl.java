package com.space.traveler.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

public abstract class BaseDaoImpl<T extends Serializable> implements BaseDao<T> {

    @PersistenceContext
    protected EntityManager entityManager;

    private Class<T> entityType;

    public BaseDaoImpl() {
        this.entityType = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }

    public T findOne(String id) {
        return entityManager.find(entityType, id);
    }

    @Override
    public List<T> findAll() {
        return entityManager.createQuery("FROM" + entityType.getName()).getResultList();
    }

    public void create(T entity) {
        entityManager.persist(entity);
    }

    public T update(T entity) {
        return entityManager.merge(entity);
    }

    public void delete(T entity) {
        entityManager.remove(entity);
    }

    public void deleteById(String id) {
        T entity = findOne(id);
        delete(entity);
    }
}
