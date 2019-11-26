package com.systechInterns.controllers.Books.generalBook;

import com.google.gson.Gson;

import com.systechInterns.Beans.BookBeanI;
import com.systechInterns.library.Book;
import com.systechInterns.studentmodule.Student;
import com.systechInterns.util.Util;
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
    @EJB
    BookBeanI bookBeanI;


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try{
            req.getRequestDispatcher("/views/books/BorrowBook.jsp").forward(req, resp);
        }catch (Exception e){
            e.printStackTrace();
        }


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Map<String, String> map = new HashMap<>();
        String bookIsbn = req.getParameter("bookIsbn");
        String studentRegNo = req.getParameter("registrationNumber");

        String returnDate = req.getParameter("dateOfReturn");
        System.out.println(returnDate);

        Book book = bookBeanI.findBook(bookIsbn);
//        if (book != null) {
//            book.setIsAvailableStr("YES");
//            bo;
//        }

        if (book != null && book.isAvailable()) {
            map.put("registrationNumber", studentRegNo);
            map.put("dateOfReturn", String.valueOf(returnDate));
            map.put("bookIsbn", String.valueOf(bookIsbn));
            try {
                Student student = new Gson().fromJson(new Util().findStudentByRegNo(studentRegNo), Student.class);
                long studentId = student.getId();
                issueWs.add(new Gson().toJson(map));
                resp.sendRedirect("acc");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        else {
            req.setAttribute("bookNotAvailable", "Book with provided isbn is not available");
            System.out.println("Book with provided isbn is not available");
//            resp.sendRedirect(req.getHeader("referer"));
            resp.sendRedirect("error");
        }

    }
}
