package com.systechInterns.controllers.Books.generalBook;

import com.systechInterns.Beans.BookBeanI;
import com.systechInterns.library.Book;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ListBooks extends HttpServlet {
    @EJB
    BookBeanI bookBeanI;
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        viewAllBooks(req, resp, bookBeanI);
    }

    public static void viewAllBooks(HttpServletRequest req, HttpServletResponse resp, BookBeanI bookBeanI) {
        try {
            List<Book> books = bookBeanI.readAll();
            List<Book> bookList = new ArrayList<>();
            for (Book book : books) {
                if (book.isAvailable())
                    book.setIsAvailableStr("YES");
                else
                    book.setIsAvailableStr("NO");

                bookList.add(book);
            }
            req.setAttribute("books", bookList);
        } catch (Exception e) {
            System.out.println("Got an error..");
            e.printStackTrace();
        }
    }
}

