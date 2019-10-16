package com.systechInterns.library;


import com.systechInterns.studentmodule.Student;

import javax.json.bind.annotation.JsonbDateFormat;
import javax.persistence.*;
import java.util.Date;

@Entity
@NamedQueries({
        @NamedQuery(name = "NQ_FIND_ALL_ISSUES",query = "select s from Issue s"),
        @NamedQuery(name = "NQ_SELECT_STUDENT_ISSUES",query = "select s from Issue s where s.studentId = : studentId"),
        @NamedQuery(name = "NQ_DELETE_STUDENT_ISSUES",query = "select s from Issue s where s.studentId = : studentId"),
        @NamedQuery(name = "NQ_GET_STUDENT_ID",query = "select s from Issue s where s.studentId = : studentId"),
        @NamedQuery(name = "NQ_GET_AND_ISBN",query = "select s from Issue s where s.studentId = : studentId and s.book.isbn=:bookIsbn"),
        @NamedQuery(name = "NQ_DELETE_BOOK_ID",query = "select s from Issue s where s.book.id = : bookId"),
        @NamedQuery(name = "NQ_SELECT_BOOK",query = "select s from Issue s where s.book.isbn = : bookIsbn and s.book.isAvailable=true")
})
@Table(name = "tbl_issues")
public class Issue {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private long studentId;
    @OneToOne(fetch = FetchType.EAGER)
    private Book book;
    @Temporal(TemporalType.DATE)
//    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern =" yyy-MM-dd")
    @JsonbDateFormat
    private Date dateOfIssue;
    private int issuePeriod;
    @Column(columnDefinition="default '0'")
    private int renewCount;
    @Temporal(TemporalType.DATE)
    @JsonbDateFormat
    private Date dateOfReturn;


    public Issue() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    
    public long getStudentId() {
        return studentId;
    }

    public void setStudentId(long studentId) {
        this.studentId = studentId;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Date getDateOfIssue() {
        return dateOfIssue;
    }

    public void setDateOfIssue(Date dateOfIssue) {
        this.dateOfIssue = dateOfIssue;
    }

    public int getIssuePeriod() {
        return issuePeriod;
    }

    public void setIssuePeriod(int issuePeriod) {
        this.issuePeriod = issuePeriod;
    }

    public int getRenewCount() {
        return renewCount;
    }

    public void setRenewCount(int renewCount) {
        this.renewCount = renewCount;
    }

    public Date getDateOfReturn() {
        return dateOfReturn;
    }

    public void setDateOfReturn(Date dateOfReturn) {
        this.dateOfReturn = dateOfReturn;
    }

    @Override
    public String toString() {
        return "Issue{" +
                "id=" + id +
                ", studentId=" + studentId +
                ", book=" + book +
                ", dateOfIssue=" + dateOfIssue +
                ", issuePeriod=" + issuePeriod +
                ", renewCount=" + renewCount +
                ", dateOfReturn=" + dateOfReturn +
                '}';
    }
}

