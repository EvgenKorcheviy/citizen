package com.space.traveler.dao;

import java.util.List;

public interface BaseDao<T> {

    T findOne(String id);

    List<T> findAll();

    void create(T entity);

    T update(T entity);

    void delete(T entity);

    void deleteById(String id);

}
