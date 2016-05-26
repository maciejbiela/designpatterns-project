package io.github.maciejbiela.designpatternsproject.core.model;

import java.time.LocalDate;
import java.util.List;

public class Borrow {
    private final Borrower borrower;
    private final List<Item> items;
    private final LocalDate borrowDate;

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
}