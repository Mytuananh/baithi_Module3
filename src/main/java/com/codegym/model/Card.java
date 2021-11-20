package com.codegym.model;

public class Card {
    private int id;
    private boolean status;
    private String borrowDate;
    private String payDate;
    private Book book;
    private Student student;

    public Card() {
    }

    public Card(boolean status, String borrowDate, String payDate, Book book, Student student) {
        this.status = status;
        this.borrowDate = borrowDate;
        this.payDate = payDate;
        this.book = book;
        this.student = student;
    }

    public Card(int id, boolean status, String borrowDate, String payDate, Book book, Student student) {
        this.id = id;
        this.status = status;
        this.borrowDate = borrowDate;
        this.payDate = payDate;
        this.book = book;
        this.student = student;
    }

    public Card(int id, boolean status, String borrowDate, String payDate) {
        this.id = id;
        this.status = status;
        this.borrowDate = borrowDate;
        this.payDate = payDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getBorrowDate() {
        return borrowDate;
    }

    public void setBorrowDate(String borrowDate) {
        this.borrowDate = borrowDate;
    }

    public String getPayDate() {
        return payDate;
    }

    public void setPayDate(String payDate) {
        this.payDate = payDate;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public void setStatus(int i) {
    }
}
