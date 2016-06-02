package io.github.maciejbiela.designpatternsproject.entrypoints.rest;

import io.github.maciejbiela.designpatternsproject.core.model.item.Item;
import io.github.maciejbiela.designpatternsproject.core.usecases.item.ItemUseCases;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ItemsEndpoint {
    private ItemUseCases itemUseCases;

    public ItemsEndpoint(ItemUseCases itemUseCases) {
        this.itemUseCases = itemUseCases;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/items")
    public List<Item> getAllItems() {
        return itemUseCases.getAllItemsUseCase().execute();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/item/{id}")
    public Item getSingleItem(@PathVariable Long id) {
        return itemUseCases.getSingleItemUseCase().execute(id);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/item", consumes = {"application/json"})
    public void update(@RequestBody Item item) {
        itemUseCases.addItemUseCase().execute(item);
    }
}
