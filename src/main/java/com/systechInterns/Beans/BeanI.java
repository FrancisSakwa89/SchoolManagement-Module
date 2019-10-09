package com.systechInterns.Beans;

import com.systechInterns.library.Book;

import java.sql.SQLException;

public interface BeanI<T> {
    T add(T t);
    T findBy(long id);
    T update(T t);
    T find(T t);
    T read(long id) ;
    boolean delete(T t);
}
