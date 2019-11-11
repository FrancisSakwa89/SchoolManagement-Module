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
import java.util.concurrent.TimeUnit;

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
    public List<Issue> deleteIssuesForStudent(long studentId, String bookIsbn) {
        List<Issue> issueList = this
                .entityManager
                .createNamedQuery("NQ_DELETE_STUDENT_ISSUES")
                .setParameter("studentId", studentId)
                .setParameter("bookIsbn", bookIsbn)
                .getResultList();
        for (Issue issue : issueList) {

            entityManager.remove(issue);
            Book book = bookBeanI.getIsbn(bookIsbn);
            book.setAvailable(true);
            bookBeanI.update(book);
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
    public Issue renewBook(long studentId, String bookIsbn) {
        return (Issue) this
                .entityManager
                .createNamedQuery("NQ_RENEW_BOOK")
                .setParameter("studentId", studentId)
                .setParameter("bookIsbn", bookIsbn)
                .getSingleResult();
    }

    @Override
    public List<Issue> calculateFine(long StudentId, Date dateOfReturn, Date dateRequiredToReturn,String bookIsbn) {
            Double amount = 10.0;
            List<Issue> issueList = this
                    .entityManager
                    .createNamedQuery("NQ_GET_AND_ISBN")
                    .setParameter("studentId", StudentId)
                    .setParameter("bookIsbn", bookIsbn)
                    .getResultList();
        try {
            issueI.findIssuesForStudent(bookBeanI.searchBookByIsbn(bookIsbn).getId());
        } catch (SearchedBookNotFoundException e) {
            e.printStackTrace();
        }
        dateOfReturn = new Date();

            for (Issue issue : issueList){
                dateRequiredToReturn = issue.getDateOfReturn();
                int diff = (int) (dateOfReturn.getTime() - dateRequiredToReturn.getTime());
                int issuePeriod = (int) TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
                if (issuePeriod > 0) {

                    double totalFine = issuePeriod * amount;
                    System.out.println("Your fine is: "+ totalFine);
                }
            }

            return issueList;
    }
//    return bookList.size()>0?bookList.get(0):null;



    }


