package com.systechInterns.controllers.Books.generalBook;

import com.google.gson.Gson;
import com.systechInterns.Beans.BookBeanI;
import com.systechInterns.exceptions.SearchedBookNotFoundException;
import com.systechInterns.library.Book;
import com.systechInterns.webservices.BookWs;
import com.systechInterns.webservices.IssueWs;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


@WebServlet(name = "searchBook", urlPatterns = "/searchBook")
public class SearchBookServlet extends HttpServlet {

    @EJB
    BookBeanI bookBeanI;

    @EJB
    BookWs bookWs;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/views/books/SearchBookById.jsp").forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String bookIsbn = req.getParameter("bookIsbn");
        Map<String, String> map = new HashMap<>();
        map.put("isbn", bookIsbn);
        try {
            bookWs.searchBook(new Gson().toJson(map));
        } catch (SearchedBookNotFoundException e) {
            e.printStackTrace();
        }


        try {
            Book book = bookBeanI.findBook(bookIsbn);
            int count = 0;
            if (book != null && book.getIsbn().equalsIgnoreCase(bookIsbn)) {
                count++;
                req.setAttribute("succ", "Found the following books..."+" "+bookIsbn);
                req.setAttribute("bookIsbn", bookIsbn);
                req.setAttribute("count", count);
                RequestDispatcher requestDispatcher = req.getRequestDispatcher("/views/userLogin/bookResults.jsp");
                requestDispatcher.forward(req, resp);

            }else {
                req.setAttribute("succ", "Not found...");
                req.setAttribute("bookIsbn", bookIsbn);
                req.setAttribute("count", count);
                RequestDispatcher requestDispatcher = req.getRequestDispatcher("/views/userLogin/bookResults.jsp");
                requestDispatcher.forward(req, resp);
                System.out.println("Book not exist...");
            }


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
