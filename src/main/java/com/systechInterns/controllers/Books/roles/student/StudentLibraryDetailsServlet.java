package com.systechInterns.controllers.Books.roles.student;

import com.systechInterns.Beans.IssueI;
import com.systechInterns.library.Issue;

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
        Issue issue = issueI.StudentLibraryDetails(regNo);
//        req.setAttribute("issue",issue);
//        req.getRequestDispatcher("libDetails").forward(req,resp);

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.getRequestDispatcher("views/books/studentDetails.jsp").forward(req,resp);

    }
}
