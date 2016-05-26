package io.github.maciejbiela.designpatternsproject.core.model;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

public class Borrow {
    protected final Borrower borrower;
    protected final List<Item> items;
    protected final LocalDate borrowDate;

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

    public LocalDate getBorrowDate() {
        return borrowDate;
    }

    @Override
    public String toString() {
        return "Borrow[borrower='" + borrower.getName() + "', " +
                "items=(" + getItemsAsString() + "), " +
                "date=" + borrowDate + "]";
    }

    private String getItemsAsString() {
        return items.stream().map(Item::getName).collect(Collectors.joining("','", "'", "'"));
    }
}