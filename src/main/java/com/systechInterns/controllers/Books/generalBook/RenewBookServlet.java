package com.systechInterns.controllers.Books.generalBook;

import com.google.gson.Gson;
import com.systechInterns.Beans.IssueI;
import com.systechInterns.library.Issue;
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

@WebServlet(name = "renewBook", urlPatterns = "/renewBook")
public class RenewBookServlet extends HttpServlet {
    @EJB
    IssueI issueI;

    @EJB
    IssueWs issueWs;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Map<String, String> map = new HashMap<>();
        String regNo = req.getParameter("registrationNumber");
        String bookIsbn = req.getParameter("bookIsbn");
        String newReturnDate = req.getParameter("newDate");
        System.out.println(newReturnDate+" "+ bookIsbn);
        map.put("registrationNumber",regNo);
        map.put("bookIsbn",bookIsbn);
        map.put("newReturnDate",newReturnDate);
        issueWs.renewBook(new Gson().toJson(map));


    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/views/books/renewBook.jsp").forward(req,resp);
    }
}
