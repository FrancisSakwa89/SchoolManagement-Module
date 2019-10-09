package com.systechInterns.Beans;


import com.systechInterns.library.Book;

import javax.ejb.Local;
import javax.ejb.Stateless;
import java.sql.SQLException;
import java.util.List;
import javax.annotation.PostConstruct;

@Stateless
@Local
public class BookBean extends Bean<Book> implements BookBeanI {
    @PostConstruct
    public void init() {
        this.entityClass = Book.class;
    }

    @Override
    public void trackBook() {

    }

    @Override
    public List<Book> readAll() throws SQLException {
        List<Book> books=this
                .entityManager
                .createNamedQuery("NQ_SELECT_BOOKS")
                .getResultList();
        System.out.println(books);
        return books;
    }

    @Override
    public List<Book> findByName(String name) {

        return this
                .entityManager
                .createNamedQuery("NQ_FIND_BOOK_BY_NAME")
                .setParameter("bookName", name)
                .getResultList();

    }

    @Override
    public List<Book> findById(long id) {

        return this
                .entityManager
                .createNamedQuery("NQ_FIND_BOOK_STUDENT")
                .setParameter("id", id)
                .getResultList();

    }
    @Override
    public List<Book> getBorrowedBooks() {

        return this
                .entityManager
                .createNamedQuery("NQ_FIND_BOOK_BORROWED")
                .getResultList();

    }

    @Override
    public List<Book> getAvailableBooks() {
        return this
                .entityManager
                .createNamedQuery("NQ_FIND_AVAILABLE_BOOK")
                .getResultList();

    }


}