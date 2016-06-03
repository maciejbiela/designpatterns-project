package io.github.maciejbiela.designpatternsproject.core.model.borrower;

public interface Borrower {
    Long getId();

    void setId(Long id);

    String getName();

    void setName(String name);

    BorrowerType getType();

    void setType(BorrowerType type);
}
