package com.systechInterns.controllers.Books;

import com.systechInterns.Beans.IssueI;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet(name = "stuDetails", urlPatterns = "/stuDetails")
public class StudentLibraryDetailsServlet extends HttpServlet {
    @EJB
    IssueI issueI;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String regNo = req.getParameter("registrationNumber");
        issueI.StudentLibraryDetails(regNo);

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("views/books/studentDetails.jsp").forward(req,resp);

    }
}
