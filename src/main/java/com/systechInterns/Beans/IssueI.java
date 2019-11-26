package com.systechInterns.Beans;

import com.systechInterns.library.Book;
import com.systechInterns.library.Issue;

import javax.ejb.Local;
import javax.inject.Qualifier;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import java.util.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static java.lang.annotation.ElementType.CONSTRUCTOR;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Local
public interface IssueI extends BeanI<Issue> {
    @Qualifier
    @Target({ElementType.TYPE,ElementType.FIELD,METHOD,PARAMETER,CONSTRUCTOR})
    @Retention(RUNTIME)

    @interface issue{

    }

    @Qualifier
    @Target({ElementType.TYPE,ElementType.FIELD,METHOD,PARAMETER,CONSTRUCTOR})
    @Retention(RUNTIME)
    @interface receive{

    }
    ArrayList<Book> onHoldBooksRequests() throws SQLException;
    List<Issue> readAll() throws SQLException;
    List<Issue> findById(long id);
    List<Issue> findIssuesForStudent(long studentId);
    List<Issue> deleteIssuesForStudent(long studentId, String bookIsbn);
    Issue StudentLibraryDetails(String regNo);
    Issue renewBook(long studentId, String bookIsbn);
    double calculateFine(long StudentId,String bookIsbn, Date dateOfReturn, Date dateRequiredToReturn);

}
