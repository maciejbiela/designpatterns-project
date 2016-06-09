package io.github.maciejbiela.designpatternsproject.core.usecases.item;

import io.github.maciejbiela.designpatternsproject.core.repositories.items.ItemsRepository;
import io.github.maciejbiela.designpatternsproject.core.usecases.item.add.AddItemUseCase;
import io.github.maciejbiela.designpatternsproject.core.usecases.item.get.all.GetAllItemsUseCase;
import io.github.maciejbiela.designpatternsproject.core.usecases.item.get.available.GetAvailableItemsUseCase;
import io.github.maciejbiela.designpatternsproject.core.usecases.item.get.single.GetSingleItemUseCase;
import io.github.maciejbiela.designpatternsproject.core.usecases.item.get.unavailable.GetUnavailableItemsUseCase;

public class ItemUseCases {
    private ItemsRepository itemsRepository;

    public ItemUseCases(ItemsRepository itemsRepository) {
        this.itemsRepository = itemsRepository;
    }

    public AddItemUseCase addItemUseCase() {
        return new AddItemUseCase(itemsRepository);
    }

    public GetAllItemsUseCase getAllItemsUseCase() {
        return new GetAllItemsUseCase(itemsRepository);
    }

    public GetAvailableItemsUseCase getAvailableItemsUseCase() {
        return new GetAvailableItemsUseCase(itemsRepository);
    }

    public GetSingleItemUseCase getSingleItemUseCase() {
        return new GetSingleItemUseCase(itemsRepository);
    }

    public GetUnavailableItemsUseCase getUnavailableItemsUseCase() {
        return new GetUnavailableItemsUseCase(itemsRepository);
    }
}
