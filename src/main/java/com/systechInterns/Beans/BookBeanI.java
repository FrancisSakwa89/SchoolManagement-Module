package com.systechInterns.Beans;

import com.systechInterns.exceptions.SearchedBookNotFoundException;
import com.systechInterns.library.Book;
import com.systechInterns.library.Issue;


import javax.ejb.Local;
import java.sql.SQLException;
import java.util.List;


@Local
public interface BookBeanI extends BeanI<Book> {
    List<Book> readAll() throws SQLException;
    Book findByName(String name);
    List<Book> findById(long id);
    List<Book> getBorrowedBooks();
    List<Book> getAvailableBooks();
    Book searchBookByIsbn(String bookIsbn) throws SearchedBookNotFoundException;
    Book getIsbn(String bookIsbn);
    List<Issue> returnBook(String bookIsbn, long studentId) throws SearchedBookNotFoundException;


}
