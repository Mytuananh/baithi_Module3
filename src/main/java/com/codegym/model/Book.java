package com.codegym.model;

public class Book {
    private int bId;
    private String nameBook;
    private String author;
    private String description;
    private int quantity;

    public Book() {
    }

    public Book(int bId, String nameBook, String author, String description, int quantity) {
        this.bId = bId;
        this.nameBook = nameBook;
        this.author = author;
        this.description = description;
        this.quantity = quantity;
    }

    public Book(String nameBook, String author, String description, int quantity) {
        this.nameBook = nameBook;
        this.author = author;
        this.description = description;
        this.quantity = quantity;
    }

    public int getbId() {
        return bId;
    }

    public void setbId(int bId) {
        this.bId = bId;
    }

    public String getNameBook() {
        return nameBook;
    }

    public void setNameBook(String nameBook) {
        this.nameBook = nameBook;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
