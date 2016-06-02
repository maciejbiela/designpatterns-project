package io.github.maciejbiela.designpatternsproject.core.repositories.items;

import io.github.maciejbiela.designpatternsproject.core.model.item.Item;

import java.util.List;

public interface ItemsRepository {
    Item get(Long id);

    List<Item> getAll();

    void update(Item item);
}
