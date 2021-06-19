package com.ambroziepaval.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public abstract class GenericDao {

    protected static final String connectionUrl = "jdbc:mysql://localhost:3306/biblioteca_db";
    protected static final String user = "biblioteca_user";
    protected static final String pass = "biblioteca_user_pass";

    protected Connection getConnection() throws SQLException {
        return DriverManager.getConnection(connectionUrl, user, pass);
    }
}
