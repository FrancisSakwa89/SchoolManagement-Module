package com.systechInterns.controllers.Books.generalBook;

import com.systechInterns.Beans.BookBeanI;
import com.systechInterns.library.Book;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "dlt", urlPatterns = "/dlt")
public class DeleteBookServlet extends HttpServlet {
    @EJB
    BookBeanI bookBeanI;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        long id = Long.parseLong(req.getParameter("id"));
        try {
            Book book = bookBeanI.read(id);
            bookBeanI.delete(book);
            resp.sendRedirect("libBooks");
        }catch (Exception e){
            e.printStackTrace();
        }


    }
}
