package io.github.maciejbiela.designpatternsproject.entrypoints.contract;

import io.github.maciejbiela.designpatternsproject.core.model.borrower.Borrower;

import java.util.List;

public interface BorrowersContract {
    List<Borrower> getAllBorrowers();

    Borrower getSingleBorrower(Long id);

    void update(Borrower borrower);
}
