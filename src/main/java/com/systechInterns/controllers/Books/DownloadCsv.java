package com.systechInterns.controllers.Books;

import com.systechInterns.Beans.BookBeanI;
import com.systechInterns.Beans.LoginBeanI;
import com.systechInterns.library.Book;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "csv", urlPatterns = "/csv")
public class DownloadCsv extends HttpServlet {
    @EJB
    BookBeanI bookBeanI;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/csv");
        PrintWriter w = resp.getWriter();

        try{
            List<Book> books = bookBeanI.readAll();

            w.println(GenerateCSV.generateCsvFile(books));

            w.flush();
            w.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
