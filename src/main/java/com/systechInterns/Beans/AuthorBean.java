package com.systechInterns.Beans;

import com.systechInterns.library.Author;

import javax.ejb.Stateless;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Stateless
public class AuthorBean extends Bean<Author> implements AuthorI  {
    @Override
    public List<Author> readAll() throws SQLException {
        return this
                .entityManager
                .createNamedQuery("NQ_SELECT_AUTHOR")
                .getResultList();
    }

    @Override
    public Author getAtLeastOne() {
        List<Author> authors = this
                .entityManager
                .createNamedQuery("NQ_SELECT_AUTHOR")
                .getResultList();
        return authors.size() > 0 ? authors.get(0) : null;
    }

    @Override
    public List<Author> findByName(String name) {
        return this
                .entityManager
                .createNamedQuery("NQ_FIND_AUTHOR_BY_NAME")
                .setParameter("name", name)
                .getResultList();
    }
}
