package io.github.maciejbiela.designpatternsproject.core.usecases.borrow.borrowitems;

import io.github.maciejbiela.designpatternsproject.core.repositories.BorrowersRepository;
import io.github.maciejbiela.designpatternsproject.core.repositories.ItemsRepository;

@FunctionalInterface
public interface BorrowItemsRequestValidator {
    void validate(BorrowItemsRequest request, BorrowersRepository borrowers, ItemsRepository items) throws BorrowItemsRequestValidationException;
}
