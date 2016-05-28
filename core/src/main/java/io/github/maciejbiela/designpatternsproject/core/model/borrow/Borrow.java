package io.github.maciejbiela.designpatternsproject.core.model.borrow;

import io.github.maciejbiela.designpatternsproject.core.model.borrower.Borrower;
import io.github.maciejbiela.designpatternsproject.core.model.item.Item;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Borrow {
    protected final Borrower borrower;
    protected final List<Item> items;
    protected final LocalDate borrowDate;
    protected LocalDate returnDate;

    public Borrow(Borrower borrower, List<Item> items, LocalDate borrowDate) {
        this.borrowDate = borrowDate;
        this.items = items;
        this.borrower = borrower;
    }

    public Borrower getBorrower() {
        return borrower;
    }

    public List<Item> getItems() {
        return items;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public void updateAccordingTo(Borrow borrow) {
        this.returnDate = borrow.returnDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Borrow)) return false;
        Borrow borrow = (Borrow) o;
        return Objects.equals(borrower, borrow.borrower) &&
                Objects.equals(items, borrow.items) &&
                Objects.equals(borrowDate, borrow.borrowDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(borrower, items, borrowDate);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder("Borrow[borrower=");
        builder.append(borrower);
        builder.append(",items=(");
        builder.append(getItemsAsString());
        builder.append("),borrowDate=");
        builder.append(borrowDate);
        if (returnDate != null) {
            builder.append(",returnDate=");
            builder.append(returnDate);
        }
        builder.append("]");
        return builder.toString();
    }

    private String getItemsAsString() {
        return items.stream().map(Item::toString).collect(Collectors.joining(","));
    }
}