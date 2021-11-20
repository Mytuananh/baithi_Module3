package com.codegym.service.studentService;

import com.codegym.config.ConnectionSingleton;
import com.codegym.model.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentService implements IStudenService{
    Connection connection = ConnectionSingleton.getConnection();
    @Override
    public void insert(Student student) throws SQLException {
        try {
            PreparedStatement statement= connection.prepareStatement("insert into student(studentName, className) values (?,?)");
            statement.setString(1,student.getFullName());
            statement.setString(2,student.getClassName());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Student findById(int id) {
        Student student = null;
            try {
                PreparedStatement preparedStatement = connection.prepareStatement("select * from student where id = ?");
                preparedStatement.setInt(1, id);
                ResultSet rs = preparedStatement.executeQuery();
                while (rs.next()) {
                    String fullName = rs.getString("studentName");
                    String className = rs.getString("className");
                    student = new Student(id, fullName, className);
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        return student;
    }

    @Override
    public boolean update(Student student) throws SQLException {
        boolean rowUpdate = false;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("update student set studentName = ?, className = ? where id = ?");
            preparedStatement.setString(1,student.getFullName());
            preparedStatement.setString(2,student.getClassName());
            preparedStatement.setInt(3,student.getsId());
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
            PreparedStatement preparedStatement = connection.prepareStatement("delete from student where id = ?");
            preparedStatement.setInt(1,id);
            rowDelete = preparedStatement.executeUpdate() > 0;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return rowDelete;
    }

    @Override
    public List<Student> findAll() {
        List<Student> studentList = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("select * from student");
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String fullName = rs.getString("studentName");
                String className = rs.getString("className");
                studentList.add(new Student(id, fullName, className));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return studentList;
    }
}
