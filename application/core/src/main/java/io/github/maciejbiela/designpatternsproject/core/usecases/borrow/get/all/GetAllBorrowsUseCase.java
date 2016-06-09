package io.github.maciejbiela.designpatternsproject.core.usecases.borrow.get.all;

import io.github.maciejbiela.designpatternsproject.core.model.borrow.Borrow;
import io.github.maciejbiela.designpatternsproject.core.repositories.borrow.BorrowsRepository;

import java.util.List;

public class GetAllBorrowsUseCase {
    private final BorrowsRepository borrowsRepository;

    public GetAllBorrowsUseCase(BorrowsRepository borrowsRepository) {
        this.borrowsRepository = borrowsRepository;
    }

    public List<Borrow> execute() {
        return borrowsRepository.getAll();
    }
}
