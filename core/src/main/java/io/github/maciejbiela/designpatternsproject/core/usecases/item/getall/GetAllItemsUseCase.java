package io.github.maciejbiela.designpatternsproject.core.usecases.item.getall;

import io.github.maciejbiela.designpatternsproject.core.model.Item;
import io.github.maciejbiela.designpatternsproject.core.repositories.ItemsRepository;

import java.util.List;

public class GetAllItemsUseCase {
    private final ItemsRepository itemsRepository;

    public GetAllItemsUseCase(ItemsRepository itemsRepository) {
        this.itemsRepository = itemsRepository;
    }

    public List<Item> getAllItems() {
        return itemsRepository.getAll();
    }
}
