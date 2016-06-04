package io.github.maciejbiela.designpatternsproject.dataproviders.simplejava.model;

import io.github.maciejbiela.designpatternsproject.core.model.borrow.Borrow;
import io.github.maciejbiela.designpatternsproject.core.model.borrower.Borrower;
import io.github.maciejbiela.designpatternsproject.core.model.item.Item;

import java.time.LocalDate;
import java.util.List;

public class BorrowImpl implements Borrow {
    private Long id;
    private Borrower borrower;
    private List<Item> items;
    private LocalDate borrowDate;
    private LocalDate returnDate;

    public BorrowImpl(Long id) {
        this.id = id;
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
    public Borrower getBorrower() {
        return borrower;
    }

    @Override
    public void setBorrower(Borrower borrower) {
        this.borrower = borrower;
    }

    @Override
    public List<Item> getItems() {
        return items;
    }

    @Override
    public void setItems(List<Item> items) {
        this.items = items;
    }

    @Override
    public LocalDate getBorrowDate() {
        return borrowDate;
    }

    @Override
    public void setBorrowDate(LocalDate borrowDate) {
        this.borrowDate = borrowDate;
    }

    @Override
    public LocalDate getReturnDate() {
        return returnDate;
    }

    @Override
    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
    }
}
