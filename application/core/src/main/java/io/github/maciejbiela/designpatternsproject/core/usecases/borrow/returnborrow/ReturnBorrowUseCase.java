package io.github.maciejbiela.designpatternsproject.core.usecases.borrow.returnborrow;

import io.github.maciejbiela.designpatternsproject.core.model.borrow.Borrow;
import io.github.maciejbiela.designpatternsproject.core.model.item.Item;
import io.github.maciejbiela.designpatternsproject.core.repositories.borrow.BorrowsRepository;
import io.github.maciejbiela.designpatternsproject.core.repositories.borrowers.BorrowersRepository;
import io.github.maciejbiela.designpatternsproject.core.repositories.items.ItemsRepository;

import java.time.LocalDate;

public class ReturnBorrowUseCase {
    private final BorrowersRepository borrowersRepository;
    private final BorrowsRepository borrowsRepository;
    private final ItemsRepository itemsRepository;

    public ReturnBorrowUseCase(BorrowersRepository borrowersRepository, BorrowsRepository borrowsRepository, ItemsRepository itemsRepository) {
        this.borrowersRepository = borrowersRepository;
        this.borrowsRepository = borrowsRepository;
        this.itemsRepository = itemsRepository;
    }

    public Borrow execute(Long id) {
        final Borrow borrow = borrowsRepository.get(id);
        final SimpleReturnBorrowValidator simpleReturnBorrowValidator = new SimpleReturnBorrowValidator(borrowersRepository, borrowsRepository, itemsRepository);
        simpleReturnBorrowValidator.validate(borrow);
        setItemsAsReturned(borrow);
        borrow.setReturnDate(LocalDate.now());
        borrowsRepository.update(borrow);
        return borrow;
    }

    private void setItemsAsReturned(Borrow borrow) {
        borrow.getItems().forEach(this::setItemAsReturned);
    }

    private void setItemAsReturned(Item item) {
        item.setAvailable(true);
        itemsRepository.update(item);
    }
}
