package io.github.maciejbiela.designpatternsproject.core.usecases.borrow.borrowitems;

import io.github.maciejbiela.designpatternsproject.core.model.Borrower;
import io.github.maciejbiela.designpatternsproject.core.model.Item;

import java.util.List;

public interface BorrowItemsValidator {
    void validate(Borrower borrower, List<Item> items) throws BorrowItemsValidationException;
}
