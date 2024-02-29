package com.example.lib.dao;

import com.example.lib.model.Book;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class JdbcBookDao implements BookDao {

    @Override
    public List<Book> findAll() throws SQLException {

        List<Book> books = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection("jdbc:h2:file:~/test", "sa", "1234") ){

            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from book");

            while(resultSet.next()) {
                Book book = new Book();
                book.setId(resultSet.getLong("id"));
                book.setTitle(resultSet.getString("title"));
                books.add(book);
            }

        }catch (SQLException e){
            e.printStackTrace();
        }

        return books;
    }

    @Override
    public Optional<Book> findById(long id) throws SQLException {
        try (Connection connection = DriverManager.getConnection("jdbc:h2:mem:test", "aa", "aa") ){
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from book b where b.id =" + id);
            if (resultSet.next()) {
                return Optional.of(map(resultSet));
            }
        }
        return Optional.empty();
    }

    private Book map(ResultSet resultSet) {
        Book book = new Book();
        try {
            book.setId(resultSet.getLong("ID"));
            book.setTitle(resultSet.getString("TITLE"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return book;
    }

    @Override
    public Book save(Book book) {
        return null;
    }

    @Override
    public Book update(Book book) {
        return null;
    }

}
