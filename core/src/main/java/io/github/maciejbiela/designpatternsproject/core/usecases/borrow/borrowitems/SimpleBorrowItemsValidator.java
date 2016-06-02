package io.github.maciejbiela.designpatternsproject.core.usecases.borrow.borrowitems;

import io.github.maciejbiela.designpatternsproject.core.model.borrower.Borrower;
import io.github.maciejbiela.designpatternsproject.core.model.item.Item;
import io.github.maciejbiela.designpatternsproject.core.repositories.borrowers.BorrowersRepository;
import io.github.maciejbiela.designpatternsproject.core.repositories.items.ItemsRepository;

import java.util.List;

public class SimpleBorrowItemsValidator implements BorrowItemsValidator {
    private final BorrowersRepository borrowersRepository;
    private final ItemsRepository itemsRepository;

    public SimpleBorrowItemsValidator(BorrowersRepository borrowersRepository, ItemsRepository itemsRepository) {
        this.borrowersRepository = borrowersRepository;
        this.itemsRepository = itemsRepository;
    }

    @Override
    public void validate(Borrower borrower, List<Item> items) throws BorrowItemsValidationException {
        validateBorrower(borrower);
        validateItems(items);
    }

    private void validateBorrower(Borrower borrower) {
        if (borrower == null || borrowersRepository.get(borrower.getId()) == null) {
            throw new BorrowItemsValidationException();
        }
    }

    private void validateItems(List<Item> items) {
        if (items == null) {
            throw new BorrowItemsValidationException();
        }
        for (Item item : items) {
            validateItem(item);
        }
    }

    private void validateItem(Item item) {
        if (item == null || itemsRepository.get(item.getId()) == null) {
            throw new BorrowItemsValidationException();
        }
    }
}
