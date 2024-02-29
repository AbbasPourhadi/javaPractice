package com.example.lib.dao;

import com.example.lib.model.Book;
import com.example.lib.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class HibernateBookDao implements BookDao{
    @Override
    public List<Book> findAll() throws SQLException {

        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session currentSession = sessionFactory.getCurrentSession();
        Transaction tra = currentSession.beginTransaction();
        Query<Book> query = currentSession.createQuery("select b from Book b", Book.class);
        List<Book> list = query.list();
        tra.rollback();
        return  list;
    }

    @Override
    public Optional<Book> findById(long id) throws SQLException {

        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session currentSession = sessionFactory.getCurrentSession();
        Transaction tra = currentSession.beginTransaction();
        Book book = currentSession.get(Book.class, id);
        tra.rollback();
        return Optional.ofNullable(book);
    }

    @Override
    public Book save(Book book) {

        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session currentSession = sessionFactory.getCurrentSession();
        Transaction tra = currentSession.beginTransaction();
        Serializable id = currentSession.save(book);
        tra.commit();
        book.setId((Long) id);
        return book;
    }

    @Override
    public Book update(Book book) {
        return null;
    }
}
