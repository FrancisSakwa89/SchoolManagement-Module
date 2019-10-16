package com.systechInterns.Beans;


import com.google.gson.Gson;
import com.systechInterns.cdi.events.IssueQualifier;
import com.systechInterns.cdi.events.Sms;
import com.systechInterns.exceptions.SearchedBookNotFoundException;
import com.systechInterns.library.Book;
import com.systechInterns.library.Issue;
import com.systechInterns.webservices.IssueWs;
import org.jboss.logging.Logger;

import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.Stateless;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.event.Event;
import javax.inject.Inject;


@Stateless
@Local
public class BookBean extends Bean<Book> implements BookBeanI {
    @Inject
    private transient Logger logger;

    @EJB
    IssueI issueI;

    @Inject
    @IssueQualifier.receive
    Event<Issue> returnBookEvent;

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
        logger.info(new Gson().toJson(books));
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
       List<Book> bookList=  this
                .entityManager
                .createNamedQuery("NQ_FIND_AVAILABLE_BOOK")
                .getResultList();
        logger.info(new Gson().toJson(bookList));
        return bookList;


    }

    @Override
    public Book searchBookByIsbn(String bookIsbn) {
        return (Book) this
                    .entityManager
                    .createNamedQuery("NQ_SELECT_BOOKS_BY_ISBN")
                    .setParameter("bookIsbn",bookIsbn)
                    .getSingleResult();


    }

    @Override
    public Book getIsbn(String bookIsbn) {
            return (Book) this
                    .entityManager
                    .createNamedQuery("NQ_SELECT_BOOKS_BY_ISBN")
                    .setParameter("bookIsbn",bookIsbn)
                    .getSingleResult();
//            return bookList.size()>0?bookList.get(0):null;

//            for (Book book: bookList){
//                if (book.getIsbn().equalsIgnoreCase(bookIsbn)){
//                    System.out.println("Book exist.."+ book);
//                    System.out.println(book);
//                }
//                else {
//                    System.out.println("Book with isbn number not exist...");
//                }
//            }
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
            Sms sms = new Sms();
            Date dateOfReturn = new Date();
            Date dateRequiredToBeReturned = issue.getDateOfReturn();
            if (dateOfReturn.getDay() - dateRequiredToBeReturned.getDay() > 0) {
                issueI.calculateFine(studentId,dateOfReturn,dateRequiredToBeReturned,bookIsbn);
                sms.setStatus("You have a fine to pay due to late returning of the book...Kindly clear with the finance manager..");
                returnBookEvent.fire(issue);
                System.out.println(issue);

            }
            else {
                entityManager.remove(issue);
                sms.setStatus("removed student from the list.." + issue);
                returnBookEvent.fire(issue);
                System.out.println(issue);
                System.out.println(sms);
            }


        }
        return issueList;

    }

    }



