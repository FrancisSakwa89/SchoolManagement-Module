package com.systechInterns.Beans;

import com.systechInterns.exceptions.SearchedBookNotFoundException;
import com.systechInterns.library.Author;
import com.systechInterns.library.Book;
import com.systechInterns.library.Issue;
import com.systechInterns.library.Publisher;


import javax.ejb.Local;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;


@Local
public interface BookBeanI extends BeanI<Book> {
    List<Book> readAll() throws SQLException;
    Book findByName(String name);
    List<Book> findById(long id);
    List<Book> getBorrowedBooks();
    List<Book> getAvailableBooks();
    Book searchBookByIsbn(String bookIsbn) throws SearchedBookNotFoundException;
    List<Book> getIsbn(String bookIsbn) throws SearchedBookNotFoundException;
    List<Issue> returnBook(String bookIsbn, long studentId) throws SearchedBookNotFoundException;
    void addBook(String isbn, String bookTitle,long authorId, long publisherId);
}
