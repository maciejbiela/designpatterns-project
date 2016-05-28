package io.github.maciejbiela.designpatternsproject.core.model.item;

import java.util.Objects;

public abstract class Item {
    protected String name;
    protected boolean available;

    public String getName() {
        return name;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public void updateAccordingTo(Item item) {
        this.name = item.name;
        this.available = item.available;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Item)) return false;
        Item item = (Item) o;
        return Objects.equals(name, item.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + "[name='" + name + "']";
    }
}
