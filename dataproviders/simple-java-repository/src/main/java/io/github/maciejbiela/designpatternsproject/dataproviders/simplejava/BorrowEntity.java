package io.github.maciejbiela.designpatternsproject.dataproviders.simplejava;

import io.github.maciejbiela.designpatternsproject.core.model.Borrow;
import io.github.maciejbiela.designpatternsproject.core.model.Borrower;
import io.github.maciejbiela.designpatternsproject.core.model.Item;

import java.time.LocalDate;
import java.util.List;

public class BorrowEntity extends Borrow {
    public BorrowEntity(Long id, Borrower borrower, List<Item> items, LocalDate borrowDate) {
        super(id, borrower, items, borrowDate);
    }
}
