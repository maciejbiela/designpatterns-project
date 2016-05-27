package io.github.maciejbiela.designpatternsproject.core.usecases.borrower.add;

import io.github.maciejbiela.designpatternsproject.core.model.Borrower;
import io.github.maciejbiela.designpatternsproject.core.repositories.borrowers.BorrowersRepository;

public class AddBorrowerUseCase {
    private final BorrowersRepository borrowersRepository;

    public AddBorrowerUseCase(BorrowersRepository borrowersRepository) {
        this.borrowersRepository = borrowersRepository;
    }

    public void execute(Borrower borrower) {
        borrowersRepository.update(borrower);
    }
}
