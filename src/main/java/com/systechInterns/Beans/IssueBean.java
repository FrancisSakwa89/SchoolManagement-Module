package com.systechInterns.Beans;

import com.google.gson.Gson;
import com.systechInterns.exceptions.SearchedBookNotFoundException;
import com.systechInterns.library.Book;
import com.systechInterns.library.Issue;
import com.systechInterns.webservices.IssueWs;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.Stateless;
import java.sql.SQLException;
import java.util.*;

@Stateless
@Local
public class IssueBean extends Bean<Issue> implements IssueI {
    @EJB
    IssueWs issueWs;

    @EJB
    BookBeanI bookBeanI;

    @EJB
    IssueI issueI;

    @PostConstruct
    public void init() {
        this.entityClass = Issue.class;
    }


    @Override
    public ArrayList<Book> onHoldBooksRequests() throws SQLException {
        return null;
    }

    @Override
    public List<Issue> readAll() throws SQLException {
        List<Issue> issueList = this
                .entityManager
                .createNamedQuery("NQ_FIND_ALL_ISSUES")
//                .setParameter("")
                .getResultList();
        System.out.println(issueList);
        return issueList;
    }

    @Override
    public List<Issue> findById(long id) {
        return null;
    }

    @Override
    public List<Issue> deleteBookId(long id) {
        List<Issue> issueList = this
                .entityManager
                .createNamedQuery("NQ_DELETE_BOOK_ID")
                .setParameter("bookId", id)
                .getResultList();
        for (Issue issue : issueList) {
            entityManager.remove(issue);
            System.out.println("removed student from the list.." + issue);
        }
        return issueList;
    }

    @Override
    public List<Issue> findIssuesForStudent(long studentId) {

        List<Issue> issueList = this
                .entityManager
                .createNamedQuery("NQ_SELECT_STUDENT_ISSUES")
                .setParameter("studentId", studentId)
                .getResultList();
        System.out.println(issueList);
        return issueList;

    }

    @Override
    public List<Issue> deleteIssuesForStudent(long studentId) {
        List<Issue> issueList = this
                .entityManager
                .createNamedQuery("NQ_DELETE_STUDENT_ISSUES")
                .setParameter("studentId", studentId)
                .getResultList();
        for (Issue issue : issueList) {
            entityManager.remove(issue);
            System.out.println("removed student from the list.." + issue);
        }
        return issueList;

    }

    @Override
    public Issue StudentLibraryDetails(String regNo) {
        Map<String, String> map = new HashMap();
        map.put("registrationNumber", regNo);
        issueWs.getIssueByRegNo(new Gson().toJson(map));
        return null;
    }

    @Override
    public List<Issue> calculateFine(long StudentId, Date dateOfReturn, Date dateRequiredToReturn,String bookIsbn) {
        try {
            Double amount = 10.0;
            List<Issue> issueList = this
                    .entityManager
                    .createNamedQuery("NQ_GET_AND_ISBN")
                    .setParameter("studentId", StudentId)
                    .setParameter("bookIsbn", bookIsbn)
                    .getResultList();
            issueI.findIssuesForStudent(bookBeanI.searchBookByIsbn(bookIsbn).getId());
            dateOfReturn = new Date();
            for (Issue issue : issueList){
                dateRequiredToReturn = issue.getDateOfReturn();
                if (dateOfReturn.getDay() - dateRequiredToReturn.getDay() > 0) {
                    double fine = dateOfReturn.getDay() - dateRequiredToReturn.getDay();
                    double totalFine = fine * amount;
                    System.out.println("Your fine is: "+ totalFine);
                }
            }
        } catch (SearchedBookNotFoundException e) {
            e.printStackTrace();
        }




        return null;
    }

    @Override
    public void returnBook(String regNo) {

    }


    @Override
    public List addStudentId(long id) {
        return null;
    }

    @Override
    public Book verifyBook(String bookIsbn) {
        List<Book> bookList = this
                .entityManager
                .createNamedQuery("NQ_SELECT_BOOK")
                .setParameter("bookIsbn", bookIsbn)
                .getResultList();
        System.out.println(bookList);
        return bookList.size()>0?bookList.get(0):null;


    }


    @Override
    public List getStudentId(String registrationNumber) {
        return this
                .entityManager
                .createNamedQuery("NQ_GET_STUDENT_ID")
                .setParameter("studentId", registrationNumber)
                .getResultList();
    }


    }


