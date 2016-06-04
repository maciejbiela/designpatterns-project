package io.github.maciejbiela.designpatternsproject.core.usecases.borrower.borrowitems;

import io.github.maciejbiela.designpatternsproject.core.model.borrow.Borrow;
import io.github.maciejbiela.designpatternsproject.core.model.borrower.Borrower;
import io.github.maciejbiela.designpatternsproject.core.model.item.Item;
import io.github.maciejbiela.designpatternsproject.core.repositories.borrow.BorrowsRepository;
import io.github.maciejbiela.designpatternsproject.core.repositories.borrowers.BorrowersRepository;
import io.github.maciejbiela.designpatternsproject.core.repositories.items.ItemsRepository;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

public class BorrowItemsUseCase {
    private final BorrowersRepository borrowersRepository;
    private final BorrowsRepository borrowsRepository;
    private final ItemsRepository itemsRepository;

    public BorrowItemsUseCase(BorrowersRepository borrowersRepository, BorrowsRepository borrowsRepository, ItemsRepository itemsRepository) {
        this.borrowersRepository = borrowersRepository;
        this.borrowsRepository = borrowsRepository;
        this.itemsRepository = itemsRepository;
    }

    public Borrow execute(Borrower borrower, List<Item> items, BorrowItemsValidator borrowItemsValidator) {
        borrowItemsValidator.validate(borrower, items);
        return execute(borrower, items);
    }

    public Borrow execute(Borrower borrower, List<Item> items) {
        final SimpleBorrowItemsValidator simpleBorrowItemsValidator = new SimpleBorrowItemsValidator(borrowersRepository, itemsRepository);
        simpleBorrowItemsValidator.validate(borrower, items);
        setItemsAsBorrowed(items);
        final Borrow borrow = borrowsRepository.createNewBorrow();
        borrow.setBorrowDate(LocalDate.now());
        borrow.setBorrower(borrower);
        borrow.setItems(items);
        borrowsRepository.update(borrow);
        return borrow;
    }

    public Borrow execute(Borrower borrower, Item item) {
        final List<Item> oneItem = Collections.singletonList(item);
        return execute(borrower, oneItem);
    }

    private void setItemsAsBorrowed(List<Item> items) {
        for (Item item : items) {
            setItemAsBorrowed(item);
        }
    }

    private void setItemAsBorrowed(Item item) {
        item.setAvailable(false);
        itemsRepository.update(item);
    }
}
