package io.github.maciejbiela.designpatternsproject.dataproviders.simplejava;

import io.github.maciejbiela.designpatternsproject.core.model.item.Item;

public class ItemEntity extends Item {
    public ItemEntity(String name) {
        this.name = name;
        this.available = true;
    }
}
