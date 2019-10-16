package com.systechInterns.Beans;


import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.systechInterns.exceptions.SearchedBookNotFoundException;
import com.systechInterns.library.Author;
import com.systechInterns.library.Book;
import com.systechInterns.library.Issue;
import com.systechInterns.library.Publisher;
import com.systechInterns.webservices.BookWs;
import com.systechInterns.webservices.IssueWs;
import okhttp3.internal.framed.ErrorCode;

import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.Stateless;
import java.sql.SQLException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;


@Stateless
@Local
public class BookBean extends Bean<Book> implements BookBeanI {

    @EJB
    IssueWs issueWs;

    @EJB
    IssueI issueI;

    @EJB
    BookWs bookWs;

    @EJB
    BookBeanI bookBeanI;

    @PostConstruct
    public void init() {
        this.entityClass = Book.class;
    }

    @Override
    public List<Book> readAll() throws SQLException {
        List<Book> books = this
                .entityManager
                .createNamedQuery("NQ_SELECT_BOOKS")
                .getResultList();
        System.out.println(books);
        return books;
    }

    @Override
    public Book findByName(String name) {

        return (Book) this
                .entityManager
                .createNamedQuery("NQ_FIND_BOOK_BY_NAME")
                .setParameter("bookName", name)
                .getSingleResult();

    }

    @Override
    public List<Book> findById(long id) {

        return this
                .entityManager
                .createNamedQuery("NQ_FIND_BOOK_STUDENT")
                .setParameter("id", id)
                .getResultList();

    }

    @Override
    public List<Book> getBorrowedBooks() {

        return this
                .entityManager
                .createNamedQuery("NQ_FIND_BOOK_BORROWED")
                .getResultList();

    }

    @Override
    public List<Book> getAvailableBooks() {
        return this
                .entityManager
                .createNamedQuery("NQ_FIND_AVAILABLE_BOOK")
                .getResultList();

    }

    @Override
    public Book searchBookByIsbn(String bookIsbn) {
//        try {
//            Book book = bookBeanI.searchBookByIsbn(bookIsbn);
//            if (book.getIsbn().equalsIgnoreCase(bookIsbn)){
//                System.out.println("Book exist.."+ book);
//            }
//            else {
//                System.out.println("Book with isbn number not exist...");
//            }
//        } catch (SearchedBookNotFoundException e) {
//            e.printStackTrace();
//        }
        return (Book) this
                    .entityManager
                    .createNamedQuery("NQ_SELECT_BOOKS_BY_ISBN")
                    .setParameter("bookIsbn",bookIsbn)
                    .getSingleResult();


    }

    @Override
    public List<Book> getIsbn(String bookIsbn) throws SearchedBookNotFoundException {
            List<Book> bookList = this
                    .entityManager
                    .createNamedQuery("NQ_SELECT_BOOKS_BY_ISBN")
                    .setParameter("bookIsbn",bookIsbn)
                    .getResultList();
            for (Book book: bookList){
                if (book.getIsbn().equalsIgnoreCase(bookIsbn)){
                    System.out.println("Book exist.."+ book);
                    System.out.println(book);
                }
                else {
                    System.out.println("Book with isbn number not exist...");
                }
            }
        return bookList;
    }


    @Override
    public List<Issue> returnBook(String bookIsbn, long studentId) throws SearchedBookNotFoundException {
        List<Issue> issueList =  this
                .entityManager
                .createNamedQuery("NQ_GET_AND_ISBN")
                .setParameter("bookIsbn",bookIsbn)
                .setParameter("studentId",studentId)
                .getResultList();
        for (Issue issue: issueList){
            Date dateOfReturn = new Date();
            Date dateRequiredToBeReturned = issue.getDateOfReturn();
            if (dateOfReturn.getDay() - dateRequiredToBeReturned.getDay() > 0) {
                issueI.calculateFine(studentId,dateOfReturn,dateRequiredToBeReturned,bookIsbn);
                System.out.println("You have a fine to pay due to late returning of the book...Kindly clear with the finance manager..");
            }
            else {
                entityManager.remove(issue);
                System.out.println("removed student from the list.." + issue);
            }


        }
        return issueList;

    }



    @Override
    public void addBook(String isbn, String bookTitle, long authorId, long publisherId) {
        Map<String, String> map = new HashMap();
        map.put("isbn", isbn);
        map.put("bookTitle", bookTitle);
        map.put("authorId", String.valueOf(authorId));
        map.put("publisherId", String.valueOf(publisherId));
        bookWs.add(new Gson().toJson(map));


    }



    }



