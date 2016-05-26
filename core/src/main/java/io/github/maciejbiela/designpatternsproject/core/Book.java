package io.github.maciejbiela.designpatternsproject.core;

public class Book implements Item {
    private final String name;

    public Book(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }
}
