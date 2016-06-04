package io.github.maciejbiela.designpatternsproject.dataproviders.simplejava.model;

import io.github.maciejbiela.designpatternsproject.core.model.borrower.Borrower;
import io.github.maciejbiela.designpatternsproject.core.model.borrower.BorrowerType;

public class BorrowerImpl implements Borrower {
    private Long id;
    private String name;
    private BorrowerType type;

    public BorrowerImpl(String name, BorrowerType type) {
        this.name = name;
        this.type = type;
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public BorrowerType getType() {
        return type;
    }

    @Override
    public void setType(BorrowerType type) {
        this.type = type;
    }
}
