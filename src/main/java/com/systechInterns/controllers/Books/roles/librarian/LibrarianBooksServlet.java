package com.systechInterns.controllers.Books.roles.librarian;

import com.systechInterns.Beans.BookBeanI;
import com.systechInterns.controllers.Books.generalBook.ListBooks;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "libBooks", urlPatterns = "/libBooks")
public class LibrarianBooksServlet extends HttpServlet {
    @EJB
    BookBeanI bookBeanI;
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ListBooks.viewAllBooks(req, resp, bookBeanI);
        req.getRequestDispatcher("/views/student/LibBooksView.jsp").forward(req,resp);

    }

}
