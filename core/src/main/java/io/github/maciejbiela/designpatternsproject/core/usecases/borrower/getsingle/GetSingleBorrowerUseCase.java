package io.github.maciejbiela.designpatternsproject.core.usecases.borrower.getsingle;

import io.github.maciejbiela.designpatternsproject.core.model.Borrower;
import io.github.maciejbiela.designpatternsproject.core.repositories.BorrowersRepository;

public class GetSingleBorrowerUseCase {
    private final BorrowersRepository borrowersRepository;

    public GetSingleBorrowerUseCase(BorrowersRepository borrowersRepository) {
        this.borrowersRepository = borrowersRepository;
    }

    public Borrower getSingleBorrower(String name) {
        Borrower borrower = borrowersRepository.get(name);
        if (borrower == null) {
            throw new BorrowerNotFoundException();
        }
        return borrower;
    }
}
