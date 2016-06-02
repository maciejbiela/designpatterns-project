package io.github.maciejbiela.designpatternsproject.entrypoints.rest;

import io.github.maciejbiela.designpatternsproject.core.model.item.Item;
import io.github.maciejbiela.designpatternsproject.core.usecases.item.ItemUseCases;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ItemsEndpoint {
    private ItemUseCases itemUseCases;

    public ItemsEndpoint(ItemUseCases itemUseCases) {
        this.itemUseCases = itemUseCases;
    }

    @RequestMapping("/items")
    public List<Item> getAllItems() {
        return itemUseCases.getAllItemsUseCase().execute();
    }
}
