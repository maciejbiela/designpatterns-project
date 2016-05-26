package io.github.maciejbiela.designpatternsproject.core.usecases.borrow.borrowitems;

import io.github.maciejbiela.designpatternsproject.core.repositories.BorrowersRepository;
import io.github.maciejbiela.designpatternsproject.core.repositories.ItemsRepository;

public interface BorrowItemsRequestValidator {
    void validate(BorrowItemsRequest borrowItemsRequest, BorrowersRepository borrowersRepository, ItemsRepository itemsRepository) throws BorrowItemsRequestValidationException;
}
