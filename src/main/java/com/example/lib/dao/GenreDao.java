package com.example.lib.dao;

import com.example.lib.model.Genre;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public interface GenreDao {

    List<Genre> findAll() throws SQLException;

    Optional<Genre> findById(long id) throws SQLException;

    Genre save(Genre Genre);

    Genre update(Genre Genre);

}
