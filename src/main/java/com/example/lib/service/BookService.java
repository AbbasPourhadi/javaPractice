package com.example.lib.service;

import com.example.lib.dao.BookDao;
import com.example.lib.dao.HibernateBookDao;
import com.example.lib.dao.JdbcBookDao;
import com.example.lib.model.Book;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class BookService {
    private UserService userService;
    private JdbcBookDao bookDao;
    private HibernateBookDao hibernateBookDao;

    public BookService() {
        userService = new UserService();
        bookDao = new JdbcBookDao();
        hibernateBookDao = new HibernateBookDao();
    }

    public Optional<Book> findById(Long id) {
        try {
            return bookDao.findById(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    public List<Book> getAll() throws SQLException {
        return hibernateBookDao.findAll();
    }

    public Book sava(Book book) {
        return hibernateBookDao.save(book);
    }

}
