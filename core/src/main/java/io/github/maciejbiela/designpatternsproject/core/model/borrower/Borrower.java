package io.github.maciejbiela.designpatternsproject.core.model.borrower;

import java.util.Objects;

public class Borrower {
    private Long id;
    private String name;
    private BorrowerType type;

    public Borrower(BorrowerType type, String name) {
        this.name = name;
        this.type = type;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BorrowerType getType() {
        return type;
    }

    public void updateAccordingTo(Borrower borrower) {
        this.name = borrower.name;
        this.type = borrower.type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Borrower borrower = (Borrower) o;
        return Objects.equals(name, borrower.name) &&
                type == borrower.type;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, type);
    }

    @Override
    public String toString() {
        return type + "[name='" + name + "']";
    }
}
