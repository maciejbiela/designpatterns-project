package io.github.maciejbiela.designpatternsproject.dataproviders.jpa.utilities;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public enum HibernateUtility {
    INSTANCE;

    private SessionFactory sessionFactory;

    HibernateUtility() {
        this.sessionFactory = new Configuration().configure("/hibernate.cfg.xml").buildSessionFactory();
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
