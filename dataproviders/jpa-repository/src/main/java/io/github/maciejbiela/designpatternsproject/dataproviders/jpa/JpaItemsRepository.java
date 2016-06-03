package io.github.maciejbiela.designpatternsproject.dataproviders.jpa;

import io.github.maciejbiela.designpatternsproject.core.model.item.IItem;
import io.github.maciejbiela.designpatternsproject.core.repositories.items.ItemsRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class JpaItemsRepository implements ItemsRepository {

    @Override
    public IItem get(Long id) {
        SessionFactory sessionFactory = HibernateHelper.INSTANCE.getSessionFactory();
        Session session = sessionFactory.openSession();
        final ItemEntity itemEntity = session.get(ItemEntity.class, id);
        session.close();
        return itemEntity;
    }

    @Override
    public List<IItem> getAll() {
        SessionFactory sessionFactory = HibernateHelper.INSTANCE.getSessionFactory();
        Session session = sessionFactory.openSession();
        return session.createCriteria(ItemEntity.class).list();
    }

    @Override
    public void update(IItem item) {
        ItemEntity itemEntity = new ItemEntity();
        itemEntity.setId(item.getId());
        itemEntity.setName(item.getName());
        itemEntity.setAvailable(item.isAvailable());
        itemEntity.setType(item.getType());
        SessionFactory sessionFactory = HibernateHelper.INSTANCE.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.saveOrUpdate(itemEntity);
        session.getTransaction().commit();
        session.close();
    }
}
