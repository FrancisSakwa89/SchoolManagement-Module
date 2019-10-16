package com.systechInterns.controllers.Books;

import com.google.gson.Gson;
import com.systechInterns.Beans.BookBeanI;
import com.systechInterns.Beans.IssueI;
import com.systechInterns.exceptions.SearchedBookNotFoundException;
import com.systechInterns.library.Book;

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


@WebServlet(name = "returnBook", urlPatterns = "/returnBook")
public class ReturnBookServlet extends HttpServlet {
    @EJB
    IssueI issueI;


    @EJB
    IssueWs issueWs;

    @EJB
    BookBeanI bookBeanI;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String bookIsbn = req.getParameter("bookIsbn");
        String regNo = req.getParameter("registrationNumber");
        Map<String, String> map = new HashMap<>();
        map.put("registrationNumber", regNo);
        map.put("bookIsbn", bookIsbn);

        issueWs.getIssueByRegNo(new Gson().toJson(map));

        try {
            Map<String, String> param = new HashMap<>();
            param.put("registrationNumber", regNo);
           Book book = bookBeanI.searchBookByIsbn(bookIsbn);
            if (book.getIsbn().equalsIgnoreCase(bookIsbn)) {
                long studentId = issueWs.getStudentId(new Gson().toJson(param));

                    bookBeanI.returnBook(bookIsbn,studentId);
                    book.setAvailable(true);
                }

            resp.sendRedirect("index.jsp");
        } catch (SearchedBookNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("views/issues/returnBook.jsp").forward(req, resp);

    }
}
