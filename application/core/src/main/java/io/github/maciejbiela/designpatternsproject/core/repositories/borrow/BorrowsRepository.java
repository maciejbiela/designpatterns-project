package io.github.maciejbiela.designpatternsproject.core.repositories.borrow;

import io.github.maciejbiela.designpatternsproject.core.model.borrow.Borrow;

import java.util.List;

public interface BorrowsRepository {
    Borrow get(Long id);

    List<Borrow> getAll();

    void update(Borrow borrow);

    Borrow createNewBorrow();
}
