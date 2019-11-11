package com.systechInterns.controllers.Books;

import com.systechInterns.Beans.BookBeanI;
import com.systechInterns.library.Book;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;


@WebServlet(name = "exc", urlPatterns = "/exc")
public class DownloadExcelServlet extends HttpServlet {
    @EJB
    BookBeanI bookBeanI;


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            List<Book> books = bookBeanI.readAll();
            req.setAttribute("books", books);
            RequestDispatcher rd = req.getRequestDispatcher("/views/books/bookpdf.jsp");
            rd.forward(req, resp);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
