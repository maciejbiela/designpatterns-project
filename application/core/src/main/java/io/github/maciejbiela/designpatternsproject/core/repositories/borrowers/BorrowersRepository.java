package io.github.maciejbiela.designpatternsproject.core.repositories.borrowers;

import io.github.maciejbiela.designpatternsproject.core.model.borrower.Borrower;

import java.util.List;

public interface BorrowersRepository {
    Borrower get(Long id);

    List<Borrower> getAll();

    void update(Borrower borrower);
}
