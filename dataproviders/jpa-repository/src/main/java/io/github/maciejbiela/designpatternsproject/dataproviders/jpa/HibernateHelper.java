package io.github.maciejbiela.designpatternsproject.dataproviders.jpa;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public enum HibernateHelper {
    INSTANCE;

    private SessionFactory sessionFactory;

    HibernateHelper() {
        this.sessionFactory = new Configuration().configure("/hibernate.cfg.xml").buildSessionFactory();
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
