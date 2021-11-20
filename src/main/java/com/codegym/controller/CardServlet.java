package com.codegym.controller;

import com.codegym.model.Book;
import com.codegym.model.Card;
import com.codegym.model.Student;
import com.codegym.service.bookService.BookService;
import com.codegym.service.cardService.CardService;
import com.codegym.service.studentService.StudentService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "CardServlet", value = "/cards")
public class CardServlet extends HttpServlet {
    private final BookService bookService = new BookService();
    private final StudentService studentService = new StudentService();
    private final CardService cardService = new CardService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                showCreateForm(request,response);
                break;
            default:
                listCards(request, response);
                break;
        }
    }
    private void showCreateForm(HttpServletRequest request, HttpServletResponse response) {
        int bookId = Integer.parseInt(request.getParameter("id"));
        Book book = bookService.findById(bookId);
        request.setAttribute("book",book);
        RequestDispatcher dispatcher = request.getRequestDispatcher("card/create.jsp");
        try {
            request.setAttribute("studentList",studentService.findAll());
            dispatcher.forward(request,response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }






    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                createCard(request,response);
                break;
            case "return":
                returnBook(request,response);
                break;
            default:
                listCards(request, response);
                break;
        }
    }

    private void returnBook(HttpServletRequest request, HttpServletResponse response) {
    }


    private void createCard(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher dispatcher = request.getRequestDispatcher("card/list.jsp");
        int bId = Integer.parseInt(request.getParameter("id"));

        Book book = bookService.findById(bId);
        int sId = Integer.parseInt(request.getParameter("student"));
        Student student = studentService.findById(sId);
        String borrowDate = request.getParameter("borrowDate");
        String payDate = request.getParameter("payDate");
        Card card = new Card(true,borrowDate,payDate,book,student);
        try {
            cardService.insert(card);
            request.setAttribute("cardList",cardService.findAll());
            dispatcher.forward(request,response);
        } catch (SQLException | ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void listCards(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher dispatcher = request.getRequestDispatcher("card/list.jsp");
        request.setAttribute("cardList",cardService.findAll());
        try {
            dispatcher.forward(request,response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }
}
