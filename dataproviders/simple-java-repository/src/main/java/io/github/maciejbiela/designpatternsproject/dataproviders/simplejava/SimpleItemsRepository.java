package io.github.maciejbiela.designpatternsproject.dataproviders.simplejava;

import io.github.maciejbiela.designpatternsproject.core.model.Item;
import io.github.maciejbiela.designpatternsproject.core.repositories.items.ItemsRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class SimpleItemsRepository implements ItemsRepository {
    private static final List<Item> ITEMS = new ArrayList<>();

    static {
        ITEMS.add(new ItemEntity("Ball"));
        ITEMS.add(new ItemEntity("Book"));
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
        final Optional<Item> possiblyExistingItem = ITEMS.stream()
                .filter(i -> i.equals(item))
                .findFirst();
        if (possiblyExistingItem.isPresent()) {
            possiblyExistingItem.get().updateAccordingTo(item);
        } else {
            ITEMS.add(item);
        }
    }
}
