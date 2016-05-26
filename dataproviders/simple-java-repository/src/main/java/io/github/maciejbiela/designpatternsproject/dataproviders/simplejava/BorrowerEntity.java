package io.github.maciejbiela.designpatternsproject.dataproviders.simplejava;

import io.github.maciejbiela.designpatternsproject.core.model.Borrower;

public class BorrowerEntity implements Borrower {
    private final String name;

    public BorrowerEntity(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }
}
