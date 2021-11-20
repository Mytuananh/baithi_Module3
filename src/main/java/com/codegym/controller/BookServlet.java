package com.codegym.controller;

import com.codegym.service.bookService.BookService;
import com.codegym.service.cardService.CardService;
import com.codegym.service.studentService.StudentService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "BookServlet", value = "/Book")
public class BookServlet extends HttpServlet {
    private final BookService bookService = new BookService();
    private final StudentService studentService = new StudentService();
    private final CardService cardService = new CardService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {

            default:
                listBooks(request, response);
                break;
        }
    }



    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {

            default:
                listBooks(request, response);
                break;
        }
    }


    private void listBooks(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher dispatcher = request.getRequestDispatcher("book/list.jsp");
        request.setAttribute("bookList",bookService.findAll());
        try {
            dispatcher.forward(request,response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }
}


