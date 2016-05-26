package io.github.maciejbiela.designpatternsproject.core;

public class IndividualBorrower implements Item {
    private final String name;

    public IndividualBorrower(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }
}
