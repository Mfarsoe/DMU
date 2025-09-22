package com.example.biblioteksystem;

public class Book {
    private int id;
    private String title;
    private String author;
    private String isbn;

    //Constructor
    public Book(int id, String title, String author, String ISBN) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.isbn = ISBN;
    }

    //Getters
    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getIsbn() {
        return isbn;
    }

    //Setters
    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
}
