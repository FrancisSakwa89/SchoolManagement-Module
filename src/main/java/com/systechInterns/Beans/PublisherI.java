package com.systechInterns.Beans;

import com.systechInterns.library.Publisher;

import javax.ejb.Local;
import java.sql.SQLException;
import java.util.List;

@Local
public interface PublisherI extends BeanI<Publisher> {
    List<Publisher> findById(long id);
    List<Publisher> readAll() throws SQLException;

}
