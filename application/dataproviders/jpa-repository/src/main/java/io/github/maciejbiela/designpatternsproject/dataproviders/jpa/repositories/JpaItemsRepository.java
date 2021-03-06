package io.github.maciejbiela.designpatternsproject.dataproviders.jpa.repositories;

import io.github.maciejbiela.designpatternsproject.core.model.item.Item;
import io.github.maciejbiela.designpatternsproject.core.repositories.items.ItemsRepository;
import io.github.maciejbiela.designpatternsproject.dataproviders.jpa.model.ItemEntity;
import io.github.maciejbiela.designpatternsproject.dataproviders.jpa.utilities.HibernateUtility;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class JpaItemsRepository implements ItemsRepository {

    @Override
    public Item get(Long id) {
        SessionFactory sessionFactory = HibernateUtility.INSTANCE.getSessionFactory();
        Session session = sessionFactory.openSession();
        final ItemEntity itemEntity = session.get(ItemEntity.class, id);
        session.close();
        return itemEntity;
    }

    @Override
    public List<Item> getAll() {
        SessionFactory sessionFactory = HibernateUtility.INSTANCE.getSessionFactory();
        Session session = sessionFactory.openSession();
        return session.createCriteria(ItemEntity.class).list();
    }

    @Override
    public void update(Item item) {
        ItemEntity itemEntity = new ItemEntity();
        itemEntity.setId(item.getId());
        itemEntity.setName(item.getName());
        itemEntity.setAvailable(item.isAvailable());
        itemEntity.setType(item.getType());
        SessionFactory sessionFactory = HibernateUtility.INSTANCE.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.saveOrUpdate(itemEntity);
        session.getTransaction().commit();
        session.close();
    }
}
