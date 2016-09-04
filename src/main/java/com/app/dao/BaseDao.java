package com.app.dao;

/**
 * Created by mosl on 16/9/3.
 */
public interface BaseDao<T> {

    boolean insert(T t);

    boolean delete(T t);

    boolean update(T t);
}
