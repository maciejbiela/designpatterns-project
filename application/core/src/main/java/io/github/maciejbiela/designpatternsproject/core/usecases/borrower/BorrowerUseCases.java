package io.github.maciejbiela.designpatternsproject.core.usecases.borrower;

import io.github.maciejbiela.designpatternsproject.core.repositories.borrow.BorrowsRepository;
import io.github.maciejbiela.designpatternsproject.core.repositories.borrowers.BorrowersRepository;
import io.github.maciejbiela.designpatternsproject.core.repositories.items.ItemsRepository;
import io.github.maciejbiela.designpatternsproject.core.usecases.borrower.add.AddBorrowerUseCase;
import io.github.maciejbiela.designpatternsproject.core.usecases.borrower.borrowitems.BorrowItemsUseCase;
import io.github.maciejbiela.designpatternsproject.core.usecases.borrower.get.all.GetAllBorrowersUseCase;
import io.github.maciejbiela.designpatternsproject.core.usecases.borrower.get.single.GetSingleBorrowerUseCase;
import io.github.maciejbiela.designpatternsproject.core.usecases.borrower.get.withnotreturnedborrows.GetBorrowersWithNotReturnedBorrowsUseCase;

public class BorrowerUseCases {
    private BorrowsRepository borrowsRepository;
    private BorrowersRepository borrowersRepository;
    private ItemsRepository itemsRepository;

    public BorrowerUseCases(BorrowsRepository borrowsRepository, BorrowersRepository borrowersRepository, ItemsRepository itemsRepository) {
        this.borrowsRepository = borrowsRepository;
        this.borrowersRepository = borrowersRepository;
        this.itemsRepository = itemsRepository;
    }

    public AddBorrowerUseCase addBorrowerUseCase() {
        return new AddBorrowerUseCase(borrowersRepository);
    }

    public BorrowItemsUseCase borrowItemsUseCase() {
        return new BorrowItemsUseCase(borrowersRepository, borrowsRepository, itemsRepository);
    }

    public GetAllBorrowersUseCase getAllBorrowersUseCase() {
        return new GetAllBorrowersUseCase(borrowersRepository);
    }

    public GetSingleBorrowerUseCase getSingleBorrowerUseCase() {
        return new GetSingleBorrowerUseCase(borrowersRepository);
    }

    public GetBorrowersWithNotReturnedBorrowsUseCase getBorrowersWithNotReturnedBorrowsUseCase() {
        return new GetBorrowersWithNotReturnedBorrowsUseCase(borrowsRepository);
    }
}
