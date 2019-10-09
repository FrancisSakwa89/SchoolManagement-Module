package com.systechInterns.Beans;

import com.systechInterns.library.Book;
import com.systechInterns.library.Issue;

import javax.ejb.Local;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Local
public interface IssueI extends BeanI<Issue> {
    ArrayList<Book> onHoldBooksRequests() throws SQLException;
    List<Issue> readAll() throws SQLException;
    List<Issue> findById(long id);
}
