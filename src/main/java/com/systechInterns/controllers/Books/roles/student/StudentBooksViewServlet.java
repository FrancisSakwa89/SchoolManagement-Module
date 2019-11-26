package com.systechInterns.controllers.Books.roles.student;

import com.systechInterns.Beans.BookBeanI;
import com.systechInterns.Beans.IssueI;
import com.systechInterns.controllers.Books.generalBook.ListBooks;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "studl", urlPatterns = "/studl")
public class StudentBooksViewServlet extends HttpServlet {
    @EJB
    IssueI issueI;
    @EJB
    BookBeanI bookBeanI;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        HttpSession session = req.getSession();
//        String userType = String.valueOf(session.getAttribute("userType"));
//        if (userType.equals("STUDENT")) {
//            long userId = Long.parseLong(session.getAttribute("userId").toString());
//            List<Issue> issueList = issueI.findIssuesForStudent(userId);
//            req.setAttribute("issues", issueList);
//            req.getRequestDispatcher("/views/books/studentTable.jsp").forward(req, resp);
//        }
//        else{
//            System.out.println("not applicable here");
//        }
        ListBooks.viewAllBooks(req,resp,bookBeanI);
        req.getRequestDispatcher("/views/student/studentTable.jsp").forward(req, resp);
    }
}
