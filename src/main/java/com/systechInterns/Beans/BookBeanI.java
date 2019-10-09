package com.systechInterns.Beans;

import com.systechInterns.library.Book;

import javax.ejb.Local;
import java.sql.SQLException;
import java.util.List;

@Local
public interface BookBeanI extends BeanI<Book> {
    public void trackBook();
    List<Book> readAll() throws SQLException;
    List<Book> findByName(String name);
    List<Book> findById(long id);
    List<Book> getBorrowedBooks();
    List<Book> getAvailableBooks();
}
