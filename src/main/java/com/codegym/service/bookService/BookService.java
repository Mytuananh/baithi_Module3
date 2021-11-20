package com.codegym.service.bookService;

import com.codegym.config.ConnectionSingleton;
import com.codegym.model.Book;
import com.codegym.model.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookService implements IBookService{
    Connection connection = ConnectionSingleton.getConnection();
    @Override
    public void insert(Book book) throws SQLException {
        try {
            PreparedStatement statement= connection.prepareStatement("insert into book(nameBook, author, description, quantity) values (?,?,?,?)");
            statement.setString(1,book.getNameBook());
            statement.setString(2,book.getAuthor());
            statement.setString(3, book.getDescription());
            statement.setInt(4,book.getQuantity());
            statement.executeUpdate();
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Book findById(int id) {
        Book book = null;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("select * from book where id = ?");
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                String namBook = rs.getString("nameBook");
                String author = rs.getString("author");
                String description = rs.getString("description");
                int quantity = rs.getInt("quantity");
                book = new Book(id, namBook, author, description, quantity);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return book;
    }

    @Override
    public boolean update(Book book) throws SQLException {
        boolean rowUpdate = false;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("update book set nameBook = ?, author = ?, description = ?, quantity = ? where id = ?");
            preparedStatement.setString(1,book.getNameBook());
            preparedStatement.setString(2,book.getAuthor());
            preparedStatement.setString(3,book.getDescription());
            preparedStatement.setInt(3,book.getQuantity());
            preparedStatement.setInt(4,book.getbId());
            rowUpdate = preparedStatement.executeUpdate() > 0;

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return rowUpdate;
    }

    @Override
    public boolean delete(int id) throws SQLException {
        boolean rowDelete  = false;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("delete from book where id = ?");
            preparedStatement.setInt(1,id);
            rowDelete = preparedStatement.executeUpdate() > 0;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return rowDelete;
    }

    @Override
    public List<Book> findAll() {
        List<Book> bookList = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("select * from book");
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String nameBook = rs.getString("nameBook");
                String author = rs.getString("author");
                String description = rs.getString("description");
                int quantity = rs.getInt("quantity");
                bookList.add(new Book(id, nameBook, author, description, quantity));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return bookList;
    }


}
