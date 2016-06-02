package io.github.maciejbiela.designpatternsproject.core.usecases.borrower.get.single;

import io.github.maciejbiela.designpatternsproject.core.model.borrower.Borrower;
import io.github.maciejbiela.designpatternsproject.core.repositories.borrowers.BorrowersRepository;

public class GetSingleBorrowerUseCase {
    private final BorrowersRepository borrowersRepository;

    public GetSingleBorrowerUseCase(BorrowersRepository borrowersRepository) {
        this.borrowersRepository = borrowersRepository;
    }

    public Borrower execute(Long id) {
        Borrower borrower = borrowersRepository.get(id);
        if (borrower == null) {
            throw new BorrowerNotFoundException();
        }
        return borrower;
    }
}
