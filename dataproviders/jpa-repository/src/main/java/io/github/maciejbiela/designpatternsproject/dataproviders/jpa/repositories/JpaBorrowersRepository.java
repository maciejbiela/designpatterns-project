package io.github.maciejbiela.designpatternsproject.dataproviders.jpa.repositories;

import io.github.maciejbiela.designpatternsproject.core.model.borrower.Borrower;
import io.github.maciejbiela.designpatternsproject.core.repositories.borrowers.BorrowersRepository;
import io.github.maciejbiela.designpatternsproject.dataproviders.jpa.model.BorrowerEntity;
import io.github.maciejbiela.designpatternsproject.dataproviders.jpa.utilities.HibernateUtility;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class JpaBorrowersRepository implements BorrowersRepository {
    @Override
    public Borrower get(Long id) {
        SessionFactory sessionFactory = HibernateUtility.INSTANCE.getSessionFactory();
        Session session = sessionFactory.openSession();
        final BorrowerEntity borrowerEntity = session.get(BorrowerEntity.class, id);
        session.close();
        return borrowerEntity;
    }

    @Override
    public List<Borrower> getAll() {
        SessionFactory sessionFactory = HibernateUtility.INSTANCE.getSessionFactory();
        Session session = sessionFactory.openSession();
        return session.createCriteria(BorrowerEntity.class).list();
    }

    @Override
    public void update(Borrower borrower) {
        BorrowerEntity borrowerEntity = new BorrowerEntity();
        borrowerEntity.setId(borrower.getId());
        borrowerEntity.setName(borrower.getName());
        borrowerEntity.setType(borrower.getType());
        SessionFactory sessionFactory = HibernateUtility.INSTANCE.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.saveOrUpdate(borrowerEntity);
        session.getTransaction().commit();
        session.close();
    }
}
