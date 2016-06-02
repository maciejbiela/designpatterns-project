package io.github.maciejbiela.designpatternsproject.core.usecases.item.get.single;

import io.github.maciejbiela.designpatternsproject.core.model.item.Item;
import io.github.maciejbiela.designpatternsproject.core.repositories.items.ItemsRepository;

public class GetSingleItemUseCase {
    private final ItemsRepository itemsRepository;

    public GetSingleItemUseCase(ItemsRepository itemsRepository) {
        this.itemsRepository = itemsRepository;
    }

    public Item execute(String name) {
        final Item item = itemsRepository.getByName(name);
        if (item == null) {
            throw new ItemNotFoundException();
        }
        return item;
    }
}