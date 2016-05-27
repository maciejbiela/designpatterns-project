package io.github.maciejbiela.designpatternsproject.core.repositories;

import io.github.maciejbiela.designpatternsproject.core.model.Borrower;

import java.util.List;

public interface BorrowersRepository {
    Borrower get(String name);

    List<Borrower> getAll();

    void update(Borrower borrower);
}
