package com.systechInterns.Beans;

import com.systechInterns.library.Author;

import javax.ejb.Local;
import java.sql.SQLException;
import java.util.List;

@Local
public interface AuthorI extends BeanI<Author> {
    List<Author> readAll() throws SQLException;
    Author getAtLeastOne();
    List<Author> findByName(String name);
}
