package com.systechInterns.controllers.Books;


import com.google.gson.Gson;
import com.systechInterns.Beans.BookBeanI;
import com.systechInterns.library.Book;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "allBooks", urlPatterns = "/allBooks")

public class allBooksServlet extends HttpServlet {

    @EJB
    BookBeanI bookBeanI;

    public void   AngularJsServlet() {
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("views/books/listAllBooks.jsp").forward(req, resp);
            List<Book> books = new ArrayList<>();
            try{
                books = bookBeanI.readAll();
            }catch(Exception e){
                e.printStackTrace();
            }

        String json = new Gson().toJson(books);
        resp.setContentType("application/json");
        resp.getWriter().write(json);
            System.out.println(books);

        req.setAttribute("books", books);



    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}