package com.example.lib.service;

import com.example.lib.dao.HibernateGenreDao;
import com.example.lib.model.Genre;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class GenreService {
    private final HibernateGenreDao hibernateGenreDao;

    public GenreService() {
        hibernateGenreDao = new HibernateGenreDao();
    }

    public Optional<Genre> findById(Long id) {
        try {
            return hibernateGenreDao.findById(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    public List<Genre> getAll() throws SQLException {
        return hibernateGenreDao.findAll();
    }

    public Genre sava(Genre Genre) {
        return hibernateGenreDao.save(Genre);
    }

}
