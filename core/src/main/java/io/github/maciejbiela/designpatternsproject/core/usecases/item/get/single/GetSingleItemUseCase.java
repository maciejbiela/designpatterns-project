package io.github.maciejbiela.designpatternsproject.core.usecases.item.get.single;

import io.github.maciejbiela.designpatternsproject.core.model.item.IItem;
import io.github.maciejbiela.designpatternsproject.core.repositories.items.ItemsRepository;

public class GetSingleItemUseCase {
    private final ItemsRepository itemsRepository;

    public GetSingleItemUseCase(ItemsRepository itemsRepository) {
        this.itemsRepository = itemsRepository;
    }

    public IItem execute(Long id) {
        final IItem item = itemsRepository.get(id);
        if (item == null) {
            throw new ItemNotFoundException();
        }
        return item;
    }
}
