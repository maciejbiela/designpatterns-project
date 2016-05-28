package io.github.maciejbiela.designpatternsproject.core.usecases.borrow.returnborrow;

import io.github.maciejbiela.designpatternsproject.core.model.borrow.Borrow;
import io.github.maciejbiela.designpatternsproject.core.model.borrower.Borrower;
import io.github.maciejbiela.designpatternsproject.core.model.item.Item;
import io.github.maciejbiela.designpatternsproject.core.repositories.borrow.BorrowsRepository;
import io.github.maciejbiela.designpatternsproject.core.repositories.borrowers.BorrowersRepository;
import io.github.maciejbiela.designpatternsproject.core.repositories.items.ItemsRepository;

import java.util.List;

public class SimpleReturnBorrowValidator {
    private final BorrowersRepository borrowersRepository;
    private final BorrowsRepository borrowsRepository;
    private final ItemsRepository itemsRepository;

    public SimpleReturnBorrowValidator(BorrowersRepository borrowersRepository, BorrowsRepository borrowsRepository, ItemsRepository itemsRepository) {
        this.borrowersRepository = borrowersRepository;
        this.borrowsRepository = borrowsRepository;
        this.itemsRepository = itemsRepository;
    }

    public void validate(Borrow borrow) throws ReturnBorrowValidationException {
        validateBorrow(borrow);
        validateBorrower(borrow.getBorrower());
        validateItems(borrow.getItems());
    }

    private void validateBorrow(Borrow borrow) {
        if (borrow == null || !borrowsRepository.getAll().contains(borrow)) {
            throw new ReturnBorrowValidationException();
        }
    }

    private void validateBorrower(Borrower borrower) {
        if (borrower == null || borrowersRepository.get(borrower.getName()) == null) {
            throw new ReturnBorrowValidationException();
        }
    }

    private void validateItems(List<Item> items) {
        if (items == null) {
            throw new ReturnBorrowValidationException();
        }
        for (Item item : items) {
            validateItem(item);
        }
    }

    private void validateItem(Item item) {
        if (item == null || itemsRepository.get(item.getName()) == null) {
            throw new ReturnBorrowValidationException();
        }
    }
}
