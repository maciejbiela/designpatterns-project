package io.github.maciejbiela.designpatternsproject.core.model.borrow;

import io.github.maciejbiela.designpatternsproject.core.model.borrower.Borrower;
import io.github.maciejbiela.designpatternsproject.core.model.item.Item;

import java.time.LocalDate;
import java.util.List;

public interface Borrow {
    Long getId();

    void setId(Long id);

    Borrower getBorrower();

    void setBorrower(Borrower borrower);

    List<Item> getItems();

    void setItems(List<Item> items);

    LocalDate getBorrowDate();

    void setBorrowDate(LocalDate borrowDate);

    LocalDate getReturnDate();

    void setReturnDate(LocalDate returnDate);
}