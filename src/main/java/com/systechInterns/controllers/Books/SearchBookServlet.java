package com.systechInterns.controllers.Books;

import com.google.gson.Gson;
import com.systechInterns.Beans.BookBeanI;
import com.systechInterns.exceptions.SearchedBookNotFoundException;
import com.systechInterns.webservices.BookWs;
import com.systechInterns.webservices.IssueWs;

import javax.ejb.EJB;
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
    BookWs bookWs;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/views/books/SearchBookById.jsp").forward(req,resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String bookIsbn = req.getParameter("bookIsbn");
        Map<String, String> map = new HashMap<>();
        map.put("bookIsbn",bookIsbn);
        try {
            bookWs.searchBook(new Gson().toJson(map));
        } catch (SearchedBookNotFoundException e) {
            e.printStackTrace();
        }

    }
}
