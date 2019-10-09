package com.systechInterns.library;

import com.systechInterns.studentmodule.Name;

import javax.persistence.*;

@Entity
@NamedQueries({
        @NamedQuery(name = "NQ_SELECT_AUTHOR", query = "select m from Author m"),
        @NamedQuery(name = "NQ_FIND_AUTHOR_BY_NAME",query = "select m from Author m where m.name = :name")
})
@Table(name = "tbl_authors")
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Embedded
    private Name name;

    public Author() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Name getName() {
        return name;
    }

    public void setName(Name name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Author{" +
                "id=" + id +
                ", name=" + name +
                '}';
    }
}
