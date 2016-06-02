package io.github.maciejbiela.designpatternsproject.core.repositories.items;

import io.github.maciejbiela.designpatternsproject.core.model.item.Item;

import java.util.List;

public interface ItemsRepository {
    Item getByName(String name);

    List<Item> getAll();

    void update(Item item);
}
