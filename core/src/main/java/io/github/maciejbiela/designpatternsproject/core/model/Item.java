package io.github.maciejbiela.designpatternsproject.core.model;

public abstract class Item {
    protected Long id;
    protected String name;
    protected boolean available;

    public Long getId() {
        return id;
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

    @Override
    public String toString() {
        return "Item[name='" + name + "']";
    }
}
