package com.systechInterns.controllers;

import com.systechInterns.Beans.AuthorI;
import com.systechInterns.Beans.BookBeanI;
import com.systechInterns.Beans.IssueI;
import com.systechInterns.library.Book;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "books",urlPatterns = "/books")
public class BookServlet extends HttpServlet {
    @EJB
    BookBeanI bookBeanI;
    @EJB
    IssueI issueI;
    @EJB
    AuthorI authorI;
//
//    private static String BORROW_BOOK = "/views/books/BorrowBook.jsp";
//    private static String LIST_BOOKS = "/views/books/listAllBooks.jsp";
//    private static String LIST_BORROWED_BOOKS = "/views/books/listLentBooks.jsp";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/views/books/BorrowBook.jsp").forward(req,resp);


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int bookId = Integer.parseInt(req.getParameter("bookId"));
        int studentId = Integer.parseInt(req.getParameter("studentId"));

        try {
            bookBeanI.findBy(bookId);
            Book book = bookBeanI.read(bookId);
//            issueI.borrowedBooks(book);
        }catch (Exception e){
            System.out.println("Got an sql error in bookservlet...");
            e.printStackTrace();
        }

    }
}
