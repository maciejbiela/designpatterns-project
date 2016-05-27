package io.github.maciejbiela.designpatternsproject.core.usecases.item.get.unavailable;

import io.github.maciejbiela.designpatternsproject.core.model.Item;
import io.github.maciejbiela.designpatternsproject.core.repositories.items.ItemsRepository;

import java.util.List;

import static java.util.stream.Collectors.toList;

public class GetUnavailableItemsUseCase {
    private final ItemsRepository itemsRepository;

    public GetUnavailableItemsUseCase(ItemsRepository itemsRepository) {
        this.itemsRepository = itemsRepository;
    }

    public List<Item> execute() {
        final List<Item> allItems = itemsRepository.getAll();
        return allItems.stream()
                .filter(item -> !item.isAvailable())
                .collect(toList());
    }
}
