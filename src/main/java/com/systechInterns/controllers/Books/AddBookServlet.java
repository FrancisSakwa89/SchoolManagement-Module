package com.systechInterns.controllers.Books;


import com.systechInterns.Beans.AuthorI;
import com.systechInterns.Beans.BookBeanI;
import com.systechInterns.Beans.PublisherI;
import com.systechInterns.library.Author;
import com.systechInterns.library.Book;
import com.systechInterns.library.Publisher;
import com.systechInterns.studentmodule.Name;


import javax.annotation.security.DeclareRoles;
import javax.annotation.security.RolesAllowed;
import javax.ejb.EJB;
import javax.servlet.ServletException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@DeclareRoles({"LIBRARIAN","STUDENT"})
@RolesAllowed({"LIBRARIAN"})
@WebServlet(name = "addBook", urlPatterns = "/addBook")
//@FormAuthenticationMechanismDefinition(
//        loginToContinue = @LoginToContinue(
//                loginPage = "/views/userLogin/login.jsp"))
//@ServletSecurity(
//        value = @HttpConstraint(rolesAllowed = {"LIBRARIAN"}),
//        httpMethodConstraints = {
//
//                @HttpMethodConstraint(
//                        value = "POST",
//                        rolesAllowed = {"LIBRARIAN"})
//        })

//@ServletSecurity(@HttpConstraint(rolesAllowed = "LIBRARIAN"))

public class AddBookServlet extends HttpServlet {
    @EJB
    BookBeanI bookBeanI;

    @EJB
    PublisherI publisherI;

    @EJB
    AuthorI authorI;


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("views/books/AddBook.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Book book = new Book();
        String isbn = req.getParameter("isbn");
        String bookTitle = req.getParameter("bookTitle");
        String publisherName = req.getParameter("publisherName");
        String publisherCity = req.getParameter("publisherCity");
        String publisherCountry = req.getParameter("publisherCountry");
        String authorFName = req.getParameter("authorFName");
        String authorMName = req.getParameter("authorMName");
        String authorLName = req.getParameter("authorLName");
        Author author = new Author();
        Name name = new Name();
        name.setFirstName(authorFName);
        name.setMiddleName(authorMName);
        name.setLastName(authorLName);

        author.setName(name);

        Publisher publisher = new Publisher();
        publisher.setPublisherName(publisherName);
        publisher.setPublisherCity(publisherCity);
        publisher.setPublisherCountry(publisherCountry);

        book.setPublisher(publisher);
        book.setTitle(bookTitle);
        book.setIsbn(isbn);
        book.getAuthors().add(author);
        book.setAvailable(true);
        bookBeanI.add(book);
        resp.sendRedirect("index.jsp");

    }
}
