package io.github.maciejbiela.designpatternsproject.dataproviders.simplejava.model;

import io.github.maciejbiela.designpatternsproject.core.model.item.Item;
import io.github.maciejbiela.designpatternsproject.core.model.item.ItemType;

public class ItemImpl implements Item {
    private Long id;
    private String name;
    private boolean available;
    private ItemType type;

    public ItemImpl(String name, ItemType type) {
        this.name = name;
        this.type = type;
        this.available = true;
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean isAvailable() {
        return available;
    }

    @Override
    public void setAvailable(boolean available) {
        this.available = available;
    }

    @Override
    public ItemType getType() {
        return type;
    }

    @Override
    public void setType(ItemType type) {
        this.type = type;
    }
}
