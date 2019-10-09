package com.systechInterns.Beans;

import com.systechInterns.library.Book;
import com.systechInterns.library.Issue;

import javax.annotation.PostConstruct;
import javax.ejb.Local;
import javax.ejb.Stateless;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Stateless
@Local
public class IssueBean extends Bean<Issue> implements IssueI  {
    @PostConstruct
    public void init(){
        this.entityClass = Issue.class;
    }


    @Override
    public ArrayList<Book> onHoldBooksRequests() throws SQLException {
        return null;
    }

    @Override
    public List<Issue> readAll() throws SQLException {
        List<Issue> issueList=this
                .entityManager
                .createNamedQuery("NQ_FIND_STUDENT")
                .getResultList();
        System.out.println(issueList);
        return issueList;
    }

    @Override
    public List<Issue> findById(long id) {
        return null;
    }
}
