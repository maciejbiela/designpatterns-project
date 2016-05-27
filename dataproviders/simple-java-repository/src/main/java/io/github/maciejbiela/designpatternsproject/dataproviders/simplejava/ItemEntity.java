package io.github.maciejbiela.designpatternsproject.dataproviders.simplejava;

import io.github.maciejbiela.designpatternsproject.core.model.Item;

public class ItemEntity extends Item {
    public ItemEntity(Long id, String name) {
        this.id = id;
        this.name = name;
        this.available = true;
    }
}
