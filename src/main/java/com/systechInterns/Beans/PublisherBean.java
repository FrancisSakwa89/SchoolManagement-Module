package com.systechInterns.Beans;

import com.systechInterns.library.Publisher;

import javax.ejb.Stateless;
import java.sql.SQLException;
import java.util.List;

@Stateless
public class PublisherBean extends Bean<Publisher> implements PublisherI  {
    @Override
    public List<Publisher> findById(long id) {
        return null;
    }

    @Override
    public List<Publisher> readAll() throws SQLException {
        return null;
    }
}
