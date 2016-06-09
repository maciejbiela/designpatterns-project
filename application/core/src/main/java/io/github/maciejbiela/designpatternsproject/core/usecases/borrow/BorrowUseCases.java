package io.github.maciejbiela.designpatternsproject.core.usecases.borrow;

import io.github.maciejbiela.designpatternsproject.core.repositories.borrow.BorrowsRepository;
import io.github.maciejbiela.designpatternsproject.core.repositories.borrowers.BorrowersRepository;
import io.github.maciejbiela.designpatternsproject.core.repositories.items.ItemsRepository;
import io.github.maciejbiela.designpatternsproject.core.usecases.borrow.get.all.GetAllBorrowsUseCase;
import io.github.maciejbiela.designpatternsproject.core.usecases.borrow.returnborrow.ReturnBorrowUseCase;

public class BorrowUseCases {
    private BorrowsRepository borrowsRepository;
    private BorrowersRepository borrowersRepository;
    private ItemsRepository itemsRepository;

    public BorrowUseCases(BorrowsRepository borrowsRepository, BorrowersRepository borrowersRepository, ItemsRepository itemsRepository) {
        this.borrowsRepository = borrowsRepository;
        this.borrowersRepository = borrowersRepository;
        this.itemsRepository = itemsRepository;
    }

    public GetAllBorrowsUseCase getAllBorrowsUseCase() {
        return new GetAllBorrowsUseCase(borrowsRepository);
    }

    public ReturnBorrowUseCase returnBorrowUseCase() {
        return new ReturnBorrowUseCase(borrowersRepository, borrowsRepository, itemsRepository);
    }
}
