package io.github.maciejbiela.designpatternsproject.core.usecases.borrower;

import io.github.maciejbiela.designpatternsproject.core.repositories.borrow.BorrowsRepository;
import io.github.maciejbiela.designpatternsproject.core.repositories.borrowers.BorrowersRepository;
import io.github.maciejbiela.designpatternsproject.core.usecases.borrower.add.AddBorrowerUseCase;
import io.github.maciejbiela.designpatternsproject.core.usecases.borrower.get.all.GetAllBorrowersUseCase;
import io.github.maciejbiela.designpatternsproject.core.usecases.borrower.get.single.GetSingleBorrowerUseCase;
import io.github.maciejbiela.designpatternsproject.core.usecases.borrower.get.withnotreturnedborrows.GetBorrowersWithNotReturnedBorrowsUseCase;

public class BorrowerUseCases {
    private BorrowsRepository borrowsRepository;
    private BorrowersRepository borrowersRepository;

    public BorrowerUseCases(BorrowsRepository borrowsRepository, BorrowersRepository borrowersRepository) {
        this.borrowsRepository = borrowsRepository;
        this.borrowersRepository = borrowersRepository;
    }

    public AddBorrowerUseCase addBorrowerUseCase() {
        return new AddBorrowerUseCase(borrowersRepository);
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
