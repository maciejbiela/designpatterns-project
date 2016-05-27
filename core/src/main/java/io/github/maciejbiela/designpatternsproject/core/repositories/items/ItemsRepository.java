package io.github.maciejbiela.designpatternsproject.core.repositories.items;

import io.github.maciejbiela.designpatternsproject.core.model.Item;

import java.util.List;

public interface ItemsRepository {
    Item get(String name);

    List<Item> getAll();

    void update(Item item);
}
