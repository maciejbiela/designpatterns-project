package io.github.maciejbiela.designpatternsproject.dataproviders.jpa;

import io.github.maciejbiela.designpatternsproject.core.model.item.IItem;
import io.github.maciejbiela.designpatternsproject.core.repositories.items.ItemsRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class JpaItemsRepository implements ItemsRepository {

    @Override
    public IItem get(Long id) {
        SessionFactory sessionFactory = new Configuration().configure("/hibernate.cfg.xml").buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        final ItemEntity itemEntity = session.get(ItemEntity.class, id);
        session.close();
        return itemEntity;
    }

    @Override
    public List<IItem> getAll() {
        return null;
    }

    @Override
    public void update(IItem item) {
        ItemEntity itemEntity = new ItemEntity();
        itemEntity.setId(item.getId());
        itemEntity.setName(item.getName());
        itemEntity.setAvailable(item.isAvailable());
        itemEntity.setType(item.getType());
        SessionFactory sessionFactory = new Configuration().configure("/hibernate.cfg.xml").buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.saveOrUpdate(itemEntity);
        session.getTransaction().commit();
        session.close();
    }
}
