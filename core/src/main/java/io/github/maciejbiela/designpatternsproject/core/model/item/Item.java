package io.github.maciejbiela.designpatternsproject.core.model.item;

import java.util.Objects;

public class Item {
    private String name;
    private boolean available;
    private ItemType type;

    public Item(ItemType type, String name) {
        this.name = name;
        this.available = true;
        this.type = type;
    }

    public String getName() {
        return name;
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
