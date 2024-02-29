package com.example.lib.dao;

import com.example.lib.model.Genre;
import com.example.lib.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class HibernateGenreDao implements GenreDao{
    @Override
    public List<Genre> findAll() throws SQLException {

        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session currentSession = sessionFactory.getCurrentSession();
        Transaction tra = currentSession.beginTransaction();
        Query<Genre> query = currentSession.createQuery(" from Genre g", Genre.class);
        List<Genre> list = query.list();
        tra.rollback();
        return  list;
    }

    @Override
    public Optional<Genre> findById(long id) throws SQLException {

        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session currentSession = sessionFactory.getCurrentSession();
        Transaction tra = currentSession.beginTransaction();
        Genre Genre = currentSession.get(Genre.class, id);
        tra.rollback();
        return Optional.ofNullable(Genre);
    }

    @Override
    public Genre save(Genre Genre) {

        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session currentSession = sessionFactory.getCurrentSession();
        Transaction tra = currentSession.beginTransaction();
        Serializable id = currentSession.save(Genre);
        tra.commit();
        Genre.setId((Long) id);
        return Genre;
    }

    @Override
    public Genre update(Genre Genre) {
        return null;
    }
}
