package com.systechInterns.db;

import javax.annotation.Resource;
import javax.enterprise.inject.Produces;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class MysqlConnector {
    @Resource(lookup = "java:/Scm")
    DataSource dataSource;

    @Produces
    public Connection getConnection() throws SQLException {
        return dataSource.getConnection();

    }
}
