package com.example.lib.dao;

import com.example.lib.model.Book;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public interface BookDao {

    List<Book> findAll() throws SQLException;

    Optional<Book> findById(long id) throws SQLException;

    Book save(Book book);

    Book update(Book book);

}
