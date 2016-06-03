package io.github.maciejbiela.designpatternsproject.core.usecases.item.get.all;

import io.github.maciejbiela.designpatternsproject.core.model.item.IItem;
import io.github.maciejbiela.designpatternsproject.core.repositories.items.ItemsRepository;

import java.util.List;

public class GetAllItemsUseCase {
    private final ItemsRepository itemsRepository;

    public GetAllItemsUseCase(ItemsRepository itemsRepository) {
        this.itemsRepository = itemsRepository;
    }

    public List<IItem> execute() {
        return itemsRepository.getAll();
    }
}
