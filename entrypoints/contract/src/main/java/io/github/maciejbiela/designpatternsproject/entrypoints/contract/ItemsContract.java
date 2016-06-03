package io.github.maciejbiela.designpatternsproject.entrypoints.contract;

import io.github.maciejbiela.designpatternsproject.core.model.item.IItem;

import java.util.List;

public interface ItemsContract {
    List<IItem> getAllItems();

    IItem getSingleItem(Long id);

    void update(IItem item);
}
