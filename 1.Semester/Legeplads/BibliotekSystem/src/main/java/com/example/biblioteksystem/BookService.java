package com.example.biblioteksystem;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BookService {

    public static ObservableList<Book> getDataBooks() {
        Connection conn = DatabaseConnector.connection();
        ObservableList<Book> list = FXCollections.observableArrayList();
        try {
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM user_db.books");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                list.add(new Book(Integer.parseInt(rs.getString("id")),rs.getString("name"),rs.getString("author"),rs.getString("isbn")));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

}
