package com.systechInterns.controllers.Books;

import com.systechInterns.Beans.BookBeanI;
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

@WebServlet(name = "searchBook", urlPatterns = "/searchBook")
public class SearchBookServlet extends HttpServlet {
    @EJB
    BookBeanI bookBeanI;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/views/books/SearchBookById.jsp").forward(req,resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String bookName = req.getParameter("bookName");

        try {
           List<Book> bookList = bookBeanI.findByName(bookName);
           for (Book b: bookList){
               if (b.getTitle().equalsIgnoreCase(bookName)){
                   PrintWriter out = new PrintWriter(System.out);
                   out.write("Book exists..."+ " "+bookName);
                   System.out.println("Book exists..."+ " "+bookName);
                   req.setAttribute("message", "Book exists..."+ " "+bookName);
               }
               else {
                   System.out.println("Book with the title does not exist..."+" "+bookName);
               }
           }

        }catch (Exception e){
            System.out.println("Error of finding  book by Title");
        }

    }
}
