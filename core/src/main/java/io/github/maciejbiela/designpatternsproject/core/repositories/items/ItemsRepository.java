package io.github.maciejbiela.designpatternsproject.core.repositories.items;

import io.github.maciejbiela.designpatternsproject.core.model.item.IItem;

import java.util.List;

public interface ItemsRepository {
    IItem get(Long id);

    List<IItem> getAll();

    void update(IItem item);
}
