package com.systechInterns.library;

import javax.persistence.*;


@Entity

@NamedQueries({
//        @NamedQuery(name = "NQ_SELECT_BOOKS_RETURNED", query = "select r from Return r where r.studentId = :id"),
        @NamedQuery(name = "NQ_SELECT_BOOKS_RETURNED", query = "select r from Return r"),

})

@Table(name = "tbl_bookreturns")
public class Return {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long id;
    @ManyToOne
    public Book book;
    public long studentId;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public long getStudentId() {
        return studentId;
    }

    public void setStudentId(long studentId) {
        this.studentId = studentId;
    }
}


