package com.systechInterns.controllers;

import com.google.gson.Gson;

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

@WebServlet(name = "books", urlPatterns = "/books")
public class BorrowBookServlet extends HttpServlet {

    @EJB
    IssueWs issueWs;



    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/views/books/BorrowBook.jsp").forward(req, resp);


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Map<String, String> map = new HashMap<>();
        String bookIsbn = req.getParameter("bookIsbn");
        String studentRegNo = req.getParameter("registrationNumber");

        String returnDate = req.getParameter("dateOfReturn");
        System.out.println(returnDate);


        map.put("registrationNumber", studentRegNo);
        map.put("dateOfReturn", String.valueOf(returnDate));
        map.put("bookIsbn", String.valueOf(bookIsbn));
        issueWs.add(new Gson().toJson(map));

    }
}
