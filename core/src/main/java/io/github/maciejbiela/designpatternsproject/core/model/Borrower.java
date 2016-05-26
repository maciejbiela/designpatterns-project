package io.github.maciejbiela.designpatternsproject.core.model;

public abstract class Borrower {
    protected String name;

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Borrower[name='" + name + "']";
    }
}
