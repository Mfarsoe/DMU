package com.example.biblioteksystem;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.collections.ObservableList;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class LibrarianController implements Initializable {

    @FXML
    private Button addButton;

    @FXML
    private TableColumn<Book,String> bookAuthor;

    @FXML
    private TableColumn<Book,String> bookISBN;

    @FXML
    private TableColumn<Book,String> bookName;

    @FXML
    private TableColumn<Book,Integer> bookNumber;

    @FXML
    private Button deleteButton;

    @FXML
    private TableView<Book> tableBooks;

    @FXML
    private Button updateButton;

    @FXML
    private TextField txtAuthor;

    @FXML
    private TextField txtIsbn;

    @FXML
    private TextField txtTitle;

    ObservableList<Book> listM;
    Book book = null;

    Connection conn = null;
    ResultSet rs = null;
    PreparedStatement pst = null;



    public void initialize(URL url, ResourceBundle rb) {
        UpdateBookList();
    }


    @FXML
    private void UpdateBookList() {
        bookNumber.setCellValueFactory(new PropertyValueFactory<Book,Integer>("id"));
        bookName.setCellValueFactory(new PropertyValueFactory<Book,String>("title"));
        bookAuthor.setCellValueFactory(new PropertyValueFactory<Book,String>("Author"));
        bookISBN.setCellValueFactory(new PropertyValueFactory<Book,String>("isbn"));
        listM = BookService.getDataBooks();

        tableBooks.setItems(listM);
    }

    @FXML
    void onAddButtonClick(ActionEvent event) {
        conn = DatabaseConnector.connection();
        String sql = "INSERT INTO books (name, author, isbn) VALUES (?,?,?)";
        try {
            pst = conn.prepareStatement(sql);
            pst.setString(1,txtTitle.getText());
            pst.setString(2,txtAuthor.getText());
            pst.setString(3,txtIsbn.getText());
            pst.execute();

        } catch (Exception e) {
            e.printStackTrace();
        }
        UpdateBookList();

    }

    @FXML
    void onDeleteButtonClick(ActionEvent event) {
        book = tableBooks.getSelectionModel().getSelectedItem();
        conn = DatabaseConnector.connection();
        String query = "DELETE FROM books WHERE id = " + book.getId();
        try {
            pst = conn.prepareStatement(query);
            pst.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        UpdateBookList();
    }

    @FXML
    void onUpdateButtonClick(ActionEvent event) {

    }

}
