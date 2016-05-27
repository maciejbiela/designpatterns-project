package io.github.maciejbiela.designpatternsproject.dataproviders.simplejava;

import io.github.maciejbiela.designpatternsproject.core.model.Borrower;

public class BorrowerEntity extends Borrower {
    public BorrowerEntity(String name) {
        this.name = name;
    }

    public BorrowerEntity(Borrower borrower) {
        this.name = borrower.getName();
    }
}
