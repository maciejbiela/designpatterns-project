package io.github.maciejbiela.designpatternsproject.core.repositories;

import io.github.maciejbiela.designpatternsproject.core.model.Borrow;

import java.util.List;

public interface BorrowsRepository {
    List<Borrow> getAll();

    void update(Borrow borrow);

    Long getNextId();
}
