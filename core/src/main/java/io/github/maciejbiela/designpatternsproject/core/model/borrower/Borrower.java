package io.github.maciejbiela.designpatternsproject.core.model.borrower;

import io.github.maciejbiela.designpatternsproject.core.model.WithId;

public interface Borrower extends WithId {
    String getName();

    void setName(String name);

    BorrowerType getType();

    void setType(BorrowerType type);
}
