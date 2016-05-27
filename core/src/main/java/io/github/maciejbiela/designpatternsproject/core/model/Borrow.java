package io.github.maciejbiela.designpatternsproject.core.model;

import java.time.LocalDate;
import java.util.List;
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

    public LocalDate getBorrowDate() {
        return borrowDate;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
    }

    @Override
    public String toString() {
        String s = "Borrow[borrower=" + borrower + "," +
                "items=(" + getItemsAsString() + ")," +
                "borrowDate=" + borrowDate;
        if (returnDate != null) {
            s = s + ",returnDate=" + returnDate;
        }
        return s + "]";
    }

    private String getItemsAsString() {
        return items.stream().map(Item::toString).collect(Collectors.joining(","));
    }
}