package io.github.maciejbiela.designpatternsproject.dataproviders.simplejava;

import io.github.maciejbiela.designpatternsproject.core.model.Item;
import io.github.maciejbiela.designpatternsproject.core.repositories.items.BorrowingNotAvailableItemException;
import io.github.maciejbiela.designpatternsproject.core.repositories.items.ItemNotFoundException;
import io.github.maciejbiela.designpatternsproject.core.repositories.items.ItemsRepository;
import io.github.maciejbiela.designpatternsproject.core.repositories.items.ReturningAvailableItemException;

import java.util.ArrayList;
import java.util.List;

public class SimpleItemsRepository implements ItemsRepository {
    private static final List<Item> ITEMS = new ArrayList<>();

    static {
        ITEMS.add(new ItemEntity(1L, "Core Java"));
        ITEMS.add(new ItemEntity(2L, "Clean Code"));
    }

    @Override
    public Item get(String name) {
        return ITEMS.stream()
                .filter(item -> item.getName().equals(name))
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<Item> getAll() {
        return ITEMS;
    }

    @Override
    public void update(Item item) {
        ITEMS.add(item);
    }

    @Override
    public void borrowItem(Long id) {
        final Item itemToBorrow = getItem(id);
        if (!itemToBorrow.isAvailable()) {
            throw new BorrowingNotAvailableItemException();
        }
        itemToBorrow.setAvailable(false);
    }

    @Override
    public void returnItem(Long id) {
        final Item itemToBorrow = getItem(id);
        if (itemToBorrow.isAvailable()) {
            throw new ReturningAvailableItemException();
        }
        itemToBorrow.setAvailable(true);
    }

    private Item getItem(Long id) {
        return ITEMS.stream()
                .filter(item -> item.getId().equals(id))
                .findFirst()
                .orElseThrow(ItemNotFoundException::new);
    }
}
