package io.github.maciejbiela.designpatternsproject.core.usecases.borrow.borrowitems;

import io.github.maciejbiela.designpatternsproject.core.model.Borrower;
import io.github.maciejbiela.designpatternsproject.core.model.Item;

import java.util.List;

public class BorrowItemsRequest {
    private final Borrower borrower;
    private final List<Item> items;

    public BorrowItemsRequest(Borrower borrower, List<Item> items) {
        this.borrower = borrower;
        this.items = items;
    }

    public Borrower getBorrower() {
        return borrower;
    }

    public List<Item> getItems() {
        return items;
    }
}
