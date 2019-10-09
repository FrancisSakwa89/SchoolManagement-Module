package com.systechInterns.controllers.Books;

import com.systechInterns.Beans.AuthorI;
import com.systechInterns.Beans.BookBeanI;
import com.systechInterns.Beans.IssueI;
import com.systechInterns.Beans.PublisherI;
import com.systechInterns.library.Author;
import com.systechInterns.library.Book;
import com.systechInterns.library.Publisher;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "addBook", urlPatterns = "/addBook")
public class AddBookServlet extends HttpServlet {
    @EJB
    BookBeanI bookBeanI;
//
//    @EJB
//    IssueI issueI;
//    @EJB
//    AuthorI authorI;
//    @EJB
//    PublisherI publisherI;


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("views/books/AddBook.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String isbn = req.getParameter("isbn");
        String title = req.getParameter("bookTitle");
        int publisherId = Integer.parseInt(req.getParameter("publisherId"));
        int authorId = Integer.parseInt(req.getParameter("authorId"));


        try {
            List<Author> authors = new ArrayList<>();
            for (Author author: authors){
                if (author.getId() == (authorId));
                System.out.println("author is: "+ author);

            }
            Publisher publisher = new Publisher();
            publisher.setId(publisherId);
            Author author = new Author();
            author.setId(authorId);
            System.out.println(publisher.getPublisherName());
            Book book = bookBeanI.add(new Book(isbn, title, publisher,authors));
            System.out.println(book);
            System.out.println("Added book successfully...");
        }catch (Exception e){
            System.out.println("Got an error adding new Book...");
        }



    }
}
