package com.example.biblioteksystem;

import java.sql.*;

public class DatabaseConnector {
    private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    private static final String DB_URL = "jdbc:mysql://mysql87.unoeuro.com:3306/mfarsoe_dk_db_bibsys";
    private static final String USER = "mfarsoe_dk";
    private static final String PASS = "";

    public static Connection connection() throws SQLException {
        try {
            Class.forName(JDBC_DRIVER);
            System.out.println("Connecting to database...");
            return DriverManager.getConnection(DB_URL, USER, PASS);
        } catch (ClassNotFoundException e) {
            throw new SQLException("Database driver not found",e);
        }
    }
}
