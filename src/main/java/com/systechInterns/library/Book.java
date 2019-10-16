package com.systechInterns.library;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@NamedQueries({
        @NamedQuery(name = "NQ_SELECT_BOOKS", query = "select m from Book m"),
        @NamedQuery(name = "NQ_SELECT_BOOKS_BY_ISBN", query = "select m from Book m where m.isbn=:bookIsbn"),
        @NamedQuery(name = "NQ_FIND_BOOK_BY_NAME",query = "select m from Book m where m.title = :bookName"),
        @NamedQuery(name = "NQ_FIND_BOOK_STUDENT",query = "select m from Student m where m.id = :id"),
        @NamedQuery(name = "NQ_FIND_BOOK_BORROWED",query = "select m from Book m where m.isAvailable = false"),
        @NamedQuery(name = "NQ_FIND_AVAILABLE_BOOK",query = "select m from Book m where m.isAvailable = true")
})

@Table(name = "tbl_books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "ISBN")
    private String isbn;
    private String title;
    @ManyToOne(cascade = CascadeType.ALL)
    private Publisher publisher;
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Author>  authors = new ArrayList<>();
    @Column(nullable = false, columnDefinition = "TINYINT(1)")
    private boolean isAvailable;

    public Book() {
    }

    public Book(String isbn, String title, Publisher publisher, List<Author> authors) {
        this.isbn = isbn;
        this.title = title;
        this.publisher = publisher;
        this.authors = authors;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Publisher getPublisher() {
        return publisher;
    }

    public void setPublisher(Publisher publisher) {
        this.publisher = publisher;
    }

    public List<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(List<Author> authors) {
        this.authors = authors;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", isbn='" + isbn + '\'' +
                ", title='" + title + '\'' +
                ", publisher=" + publisher +
                ", authors=" + authors +
                ", isAvailable=" + isAvailable +
                '}';
    }
}
