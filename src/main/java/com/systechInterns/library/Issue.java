package com.systechInterns.library;


import javax.persistence.*;
import java.util.Date;

@Entity
@NamedQueries({
        @NamedQuery(name = "NQ_FIND_STUDENT",query = "select s from Student s where  s.id = : id")
//        @NamedQuery(name = "NQ_FIND_BOOK_BORROWED",query = "select m from Book m where m.isAvailable = false")
})
@Table(name = "tbl_issues")
public class Issue {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private long studentId;
    @OneToOne
    private Book book;
    @Temporal(TemporalType.DATE)
    private Date dateOfIssue;
    private int issuePeriod;
    private int renewCount;
    @Temporal(TemporalType.DATE)
    private Date dateOfReturn;

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
}
