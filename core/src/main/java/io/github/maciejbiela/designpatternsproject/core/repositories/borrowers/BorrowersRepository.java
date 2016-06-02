package io.github.maciejbiela.designpatternsproject.core.repositories.borrowers;

import io.github.maciejbiela.designpatternsproject.core.model.borrower.Borrower;

import java.util.List;

public interface BorrowersRepository {
    Borrower getByName(String name);

    List<Borrower> getAll();

    void update(Borrower borrower);
}
