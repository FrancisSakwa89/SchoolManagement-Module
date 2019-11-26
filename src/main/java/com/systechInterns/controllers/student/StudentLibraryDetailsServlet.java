package com.systechInterns.controllers.student;

import com.systechInterns.Beans.IssueI;
import com.systechInterns.library.Issue;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "libDetails", urlPatterns = "/libDetails")
public class StudentLibraryDetailsServlet extends HttpServlet {
    @EJB
    IssueI issueI;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String regNo = req.getParameter("regNo");
        try {
            issueI.StudentLibraryDetails(regNo);
        }
        catch (Exception e){
            e.printStackTrace();
        }

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println(req.getAttribute("issue"));
//        Issue issue = issueI.readAll();
    }
}
