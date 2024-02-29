package com.example.lib.util;

import com.example.lib.model.Book;
import com.example.lib.model.Genre;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.AvailableSettings;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

    private static SessionFactory sessionFactory;

    private static SessionFactory init() {
        Configuration conf = new Configuration();
        conf.setProperty(AvailableSettings.URL, "jdbc:h2:file:~/test");
        conf.setProperty(AvailableSettings.USER, "sa");
        conf.setProperty(AvailableSettings.PASS, "1234");
        conf.setProperty(AvailableSettings.DRIVER, "org.h2.Driver");
        conf.setProperty(AvailableSettings.CURRENT_SESSION_CONTEXT_CLASS, "org.hibernate.context.internal.ThreadLocalSessionContext");
        conf.setProperty(AvailableSettings.HBM2DDL_AUTO, "update");
        conf.addAnnotatedClass(Book.class);
        conf.addAnnotatedClass(Genre.class);

        StandardServiceRegistry serviceRegistryBuilder
                = new StandardServiceRegistryBuilder()
                .applySettings(conf.getProperties())
                .build();

        return conf.buildSessionFactory(serviceRegistryBuilder);

    }

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null)
            sessionFactory = init();

        return sessionFactory;
    }
}
