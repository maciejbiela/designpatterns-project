package io.github.maciejbiela.designpatternsproject.core.model;

public abstract class Item {
    protected String name;

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Item[name='" + name + "']";
    }
}
