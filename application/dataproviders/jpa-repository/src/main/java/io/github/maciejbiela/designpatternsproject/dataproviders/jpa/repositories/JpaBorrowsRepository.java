package io.github.maciejbiela.designpatternsproject.dataproviders.jpa.repositories;

import io.github.maciejbiela.designpatternsproject.core.model.borrow.Borrow;
import io.github.maciejbiela.designpatternsproject.core.repositories.borrow.BorrowsRepository;
import io.github.maciejbiela.designpatternsproject.dataproviders.jpa.model.BorrowEntity;
import io.github.maciejbiela.designpatternsproject.dataproviders.jpa.utilities.HibernateUtility;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class JpaBorrowsRepository implements BorrowsRepository {
    @Override
    public Borrow get(Long id) {
        SessionFactory sessionFactory = HibernateUtility.INSTANCE.getSessionFactory();
        Session session = sessionFactory.openSession();
        final BorrowEntity borrowEntity = session.get(BorrowEntity.class, id);
        session.close();
        return borrowEntity;
    }

    @Override
    public List<Borrow> getAll() {
        SessionFactory sessionFactory = HibernateUtility.INSTANCE.getSessionFactory();
        Session session = sessionFactory.openSession();
        return session.createCriteria(BorrowEntity.class).list();
    }

    @Override
    public void update(Borrow borrow) {
        SessionFactory sessionFactory = HibernateUtility.INSTANCE.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.saveOrUpdate(borrow);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public Borrow createNewBorrow() {
        return new BorrowEntity();
    }
}
