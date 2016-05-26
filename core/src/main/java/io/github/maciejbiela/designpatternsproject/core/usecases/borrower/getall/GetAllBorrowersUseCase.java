package io.github.maciejbiela.designpatternsproject.core.usecases.borrower.getall;

import io.github.maciejbiela.designpatternsproject.core.model.Borrower;
import io.github.maciejbiela.designpatternsproject.core.repositories.BorrowersRepository;

import java.util.List;

public class GetAllBorrowersUseCase {
    private final BorrowersRepository borrowersRepository;

    public GetAllBorrowersUseCase(BorrowersRepository borrowersRepository) {
        this.borrowersRepository = borrowersRepository;
    }

    public List<Borrower> getAllBorrowers() {
        return borrowersRepository.getAll();
    }
}
