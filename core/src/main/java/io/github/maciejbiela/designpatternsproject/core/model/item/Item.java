package io.github.maciejbiela.designpatternsproject.core.model.item;

import java.util.Objects;

public class Item {
    private Long id;
    private String name;
    private boolean available;
    private ItemType type;

    public Item() {
    }

    public Item(ItemType type, String name) {
        this.name = name;
        this.available = true;
        this.type = type;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public ItemType getType() {
        return type;
    }

    public void setType(ItemType type) {
        this.type = type;
    }

    public void updateAccordingTo(Item item) {
        this.name = item.name;
        this.available = item.available;
        this.type = item.type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return available == item.available &&
                Objects.equals(name, item.name) &&
                type == item.type;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, type);
    }

    @Override
    public String toString() {
        return type + "[name='" + name + "']";
    }
}
