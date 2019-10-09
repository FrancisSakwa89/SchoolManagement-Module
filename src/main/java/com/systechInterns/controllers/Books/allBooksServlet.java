package com.systechInterns.controllers.Books;

import com.systechInterns.Beans.BookBeanI;
import com.systechInterns.library.Book;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "allBooks", urlPatterns = "/allBooks")

public class allBooksServlet extends HttpServlet {
    @EJB
    BookBeanI bookBeanI;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("views/books/listAllBooks.jsp").forward(req, resp);
        try {
            List<Book> books = bookBeanI.readAll();
            req.setAttribute("books", books);
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}