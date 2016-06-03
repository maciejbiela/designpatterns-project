package io.github.maciejbiela.designpatternsproject.core.usecases.item.add;

import io.github.maciejbiela.designpatternsproject.core.model.item.Item;
import io.github.maciejbiela.designpatternsproject.core.repositories.items.ItemsRepository;

public class AddItemUseCase {
    private final ItemsRepository itemsRepository;

    public AddItemUseCase(ItemsRepository itemsRepository) {
        this.itemsRepository = itemsRepository;
    }

    public void execute(Item item) {
        itemsRepository.update(item);
    }
}
