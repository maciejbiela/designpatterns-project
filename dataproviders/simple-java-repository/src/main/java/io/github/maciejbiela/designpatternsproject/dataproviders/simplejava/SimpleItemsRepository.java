package io.github.maciejbiela.designpatternsproject.dataproviders.simplejava;

import io.github.maciejbiela.designpatternsproject.core.model.item.Item;
import io.github.maciejbiela.designpatternsproject.core.repositories.items.ItemsRepository;

import java.util.ArrayList;
import java.util.List;

public class SimpleItemsRepository implements ItemsRepository {
    private static final List<Item> ITEMS = new ArrayList<>();

    static {
    }

    @Override
    public Item get(Long id) {
        return ITEMS.stream()
                .filter(item -> item.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<Item> getAll() {
        return ITEMS;
    }

    @Override
    public void update(Item item) {
//        final Optional<Item> possiblyExistingItem = ITEMS.stream()
//                .filter(i -> i.getId().equals(item.getId()))
//                .findFirst();
//        if (possiblyExistingItem.isPresent()) {
//            possiblyExistingItem.get().updateAccordingTo(item);
//        } else {
//            item.setId((long) (ITEMS.size() + 1));
//            ITEMS.add(item);
//        }
    }
}
