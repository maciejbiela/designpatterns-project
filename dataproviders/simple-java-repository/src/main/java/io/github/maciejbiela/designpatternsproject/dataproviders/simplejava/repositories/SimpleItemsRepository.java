package io.github.maciejbiela.designpatternsproject.dataproviders.simplejava.repositories;

import io.github.maciejbiela.designpatternsproject.core.model.item.Item;
import io.github.maciejbiela.designpatternsproject.core.model.item.ItemImpl;
import io.github.maciejbiela.designpatternsproject.core.repositories.items.ItemsRepository;

import java.util.ArrayList;
import java.util.List;

import static io.github.maciejbiela.designpatternsproject.core.model.item.ItemType.BOOK;
import static io.github.maciejbiela.designpatternsproject.core.model.item.ItemType.NOTES;

public class SimpleItemsRepository extends AbstractRepository<Item>
        implements ItemsRepository {
    private static final List<Item> ITEMS = new ArrayList<>();

    static {
        ITEMS.add(new ItemImpl("Core Java", BOOK));
        ITEMS.add(new ItemImpl("Clean Code", BOOK));
        ITEMS.add(new ItemImpl("Partial Differential Equations", NOTES));
        for (int i = 0; i < ITEMS.size(); i++) {
            ITEMS.get(i).setId((long) (i + 1));
        }
    }

    @Override
    List<Item> getRepositoryList() {
        return ITEMS;
    }

    @Override
    void update(Item actual, Item accordingTo) {
        actual.setName(accordingTo.getName());
        actual.setType(accordingTo.getType());
        actual.setAvailable(accordingTo.isAvailable());
    }
}
