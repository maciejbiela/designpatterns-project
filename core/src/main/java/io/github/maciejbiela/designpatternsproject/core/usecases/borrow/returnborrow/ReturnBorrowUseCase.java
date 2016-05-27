package io.github.maciejbiela.designpatternsproject.core.usecases.borrow.returnborrow;

import io.github.maciejbiela.designpatternsproject.core.model.Borrow;
import io.github.maciejbiela.designpatternsproject.core.model.Item;
import io.github.maciejbiela.designpatternsproject.core.repositories.borrow.BorrowsRepository;
import io.github.maciejbiela.designpatternsproject.core.repositories.borrowers.BorrowersRepository;
import io.github.maciejbiela.designpatternsproject.core.repositories.items.ItemsRepository;

public class ReturnBorrowUseCase {
    private final BorrowersRepository borrowersRepository;
    private final BorrowsRepository borrowsRepository;
    private final ItemsRepository itemsRepository;

    public ReturnBorrowUseCase(BorrowersRepository borrowersRepository, BorrowsRepository borrowsRepository, ItemsRepository itemsRepository) {
        this.borrowersRepository = borrowersRepository;
        this.borrowsRepository = borrowsRepository;
        this.itemsRepository = itemsRepository;
    }

    public Borrow execute(Borrow borrow) {
        final SimpleReturnBorrowValidator simpleReturnBorrowValidator = new SimpleReturnBorrowValidator(borrowersRepository, borrowsRepository, itemsRepository);
        simpleReturnBorrowValidator.validate(borrow);
        setItemsAsReturned(borrow);
        borrowsRepository.update(borrow);
        return borrow;
    }

    private void setItemsAsReturned(Borrow borrow) {
        for (Item item : borrow.getItems()) {
            setItemAsReturned(item);
        }
    }

    private void setItemAsReturned(Item item) {
        item.setAvailable(true);
        itemsRepository.update(item);
    }
}
