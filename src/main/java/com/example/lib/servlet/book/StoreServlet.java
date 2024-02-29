package com.example.lib.servlet.book;

import com.example.lib.model.Book;
import com.example.lib.service.BookService;
import com.example.lib.util.HibernateUtil;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "storeBookServlet", urlPatterns = "/books/store")
public class StoreServlet extends HttpServlet {

    BookService bookService = new BookService();

    /*static {
        try {
            Class.forName("org.h2.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }*/
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/views/book/store.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String title = req.getParameter("title");
        if (!title.isEmpty()){
            Book book = new Book();
            book.setTitle(title);
            bookService.sava(book);
            req.setAttribute("msg", "book saved");
            req.getRequestDispatcher("/WEB-INF/views/book/store.jsp").forward(req, resp);
        }
    }
}
