package io.github.maciejbiela.designpatternsproject.dataproviders.simplejava;

import io.github.maciejbiela.designpatternsproject.core.model.borrow.Borrow;
import io.github.maciejbiela.designpatternsproject.core.model.borrower.Borrower;
import io.github.maciejbiela.designpatternsproject.core.model.item.Item;

import java.time.LocalDate;
import java.util.List;

public class BorrowEntity extends Borrow {
    public BorrowEntity(Borrower borrower, List<Item> items, LocalDate borrowDate) {
        super(borrower, items, borrowDate);
    }
}
