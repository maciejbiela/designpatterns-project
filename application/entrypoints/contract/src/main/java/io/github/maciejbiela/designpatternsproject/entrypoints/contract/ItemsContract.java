package io.github.maciejbiela.designpatternsproject.entrypoints.contract;

import io.github.maciejbiela.designpatternsproject.core.model.item.Item;

import java.util.List;

public interface ItemsContract {
    List<Item> getAllItems();

    Item getSingleItem(Long id);

    void update(Item item);
}
