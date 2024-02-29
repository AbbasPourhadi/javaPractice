package com.example.lib.servlet;

import com.example.lib.model.Book;
import com.example.lib.service.BookService;
import com.example.lib.util.HibernateUtil;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.*;
import java.util.List;

@WebServlet(loadOnStartup = 1, name = "indexServlet", urlPatterns = "/")
public class IndexServlet extends HttpServlet {
    BookService bookService = new BookService();

    static {
        try {
            Class.forName("org.h2.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        HibernateUtil.getSessionFactory();
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try {
            List<Book> books = bookService.getAll();
            req.setAttribute("books", books);
            req.getRequestDispatcher("/WEB-INF/views/book/index.jsp").forward(req, resp);
            /*Book b = new Book();
            b.setTitle("silence of tle lambs");
            bookService.sava(b);*/

        } catch (SQLException e) {
            throw new ServletException("Error", e);
        }

    }
}
