package com.systechInterns.Beans;

import com.systechInterns.library.Book;
import com.systechInterns.library.Issue;

import javax.ejb.Local;
import java.util.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Local
public interface IssueI extends BeanI<Issue> {
    ArrayList<Book> onHoldBooksRequests() throws SQLException;
    List<Issue> readAll() throws SQLException;
    List<Issue> findById(long id);
    List<Issue> deleteBookId(long id);
    List<Issue> findIssuesForStudent(long studentId);
    List<Issue> deleteIssuesForStudent(long studentId);
    Issue StudentLibraryDetails(String regNo);
    List<Issue> calculateFine(long StudentId, Date dateOfReturn, Date dateRequiredToReturn, String bookIsbn);
    void returnBook(String regNo);
    List addStudentId(long id);
    Book verifyBook(String bookIsbn);
    List getStudentId(String registrationNumber);
}
