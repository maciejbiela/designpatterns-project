package io.github.maciejbiela.designpatternsproject.core.usecases.borrow.returnborrow;

import io.github.maciejbiela.designpatternsproject.core.model.Borrow;
import io.github.maciejbiela.designpatternsproject.core.repositories.borrow.BorrowsRepository;
import io.github.maciejbiela.designpatternsproject.core.repositories.items.ItemsRepository;

public class ReturnBorrowUseCase {
    private final BorrowsRepository borrowsRepository;
    private final ItemsRepository itemsRepository;

    public ReturnBorrowUseCase(BorrowsRepository borrowsRepository, ItemsRepository itemsRepository) {
        this.borrowsRepository = borrowsRepository;
        this.itemsRepository = itemsRepository;
    }

    public void returnBorrow(Borrow borrow) {
    }
}
