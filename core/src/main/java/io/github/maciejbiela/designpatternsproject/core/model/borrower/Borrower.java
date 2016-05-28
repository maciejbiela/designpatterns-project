package io.github.maciejbiela.designpatternsproject.core.model.borrower;

import java.util.Objects;

public abstract class Borrower {
    protected String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void updateAccordingTo(Borrower borrower) {
        this.name = borrower.name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Borrower)) return false;
        Borrower borrower = (Borrower) o;
        return Objects.equals(name, borrower.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + "[name='" + name + "']";
    }
}
