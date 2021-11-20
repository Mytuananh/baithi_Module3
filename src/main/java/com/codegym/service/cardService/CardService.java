package com.codegym.service.cardService;

import com.codegym.config.ConnectionSingleton;
import com.codegym.model.Card;
import com.codegym.model.Student;
import com.codegym.service.bookService.BookService;
import com.codegym.service.studentService.StudentService;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CardService implements ICardService {
    Connection connection = ConnectionSingleton.getConnection();
    BookService bookService = new BookService();
    StudentService studentService = new StudentService();

    @Override
    public void insert(Card card) throws SQLException {
        try {
            PreparedStatement statement = connection.prepareStatement("insert into card(bId, sId, status, borrowDate, payDate) values (?,?,?,?,?)");
            statement.setInt(1, card.getBook().getbId());
            statement.setInt(2, card.getStudent().getsId());
            statement.setBoolean(3, card.isStatus());
            statement.setString(4, card.getBorrowDate());
            statement.setString(5, card.getBorrowDate());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Card findById(int id) {
        Card card = null;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("select * from card where id = ?");
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int bId = rs.getInt("bId");
                int sId = rs.getInt("sId");
                boolean status = rs.getBoolean("status");
                String borrowDate = rs.getString("borrowDate");
                String payDate = rs.getString("payDate");
                card = new Card(id, status, borrowDate, payDate, bookService.findById(bId), studentService.findById(sId));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return card;
    }

    @Override
    public boolean update(Card card) throws SQLException {
        boolean rowUpdate = false;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("update student set bId = ?, sId = ?, status = ?, borrowDate = ?, payDate = ? where id = ?");
            preparedStatement.setInt(1, card.getBook().getbId());
            preparedStatement.setInt(2, card.getStudent().getsId());
            preparedStatement.setBoolean(3, card.isStatus());
            preparedStatement.setString(4, card.getBorrowDate());
            preparedStatement.setString(5, card.getPayDate());
            rowUpdate = preparedStatement.executeUpdate() > 0;

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return rowUpdate;

    }

    @Override
    public boolean delete(int id) throws SQLException {
        boolean rowDelete = false;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("delete from card where id = ?");
            preparedStatement.setInt(1, id);
            rowDelete = preparedStatement.executeUpdate() > 0;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return rowDelete;
    }

    @Override
    public List<Card> findAll() {
        List<Card> cardList = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("select * from card");
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                int bId = rs.getInt("bId");
                int sId = rs.getInt("sId");
                boolean status = rs.getBoolean("status");
                String borrowDate = rs.getString("borrowDate");
                String payDate = rs.getString("payDate");
                cardList.add(new Card(id, status, borrowDate, payDate, bookService.findById(bId), studentService.findById(sId)));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return cardList;
    }
}
