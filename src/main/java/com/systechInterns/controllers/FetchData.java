package com.systechInterns.controllers;

import com.systechInterns.Beans.BookBeanI;
import com.systechInterns.library.Book;

import javax.ejb.EJB;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class FetchData {
    @EJB
    BookBeanI bookBeanI;
    public List<Book> getAllBooks() throws SQLException {
        return bookBeanI.readAll();
    }
}
