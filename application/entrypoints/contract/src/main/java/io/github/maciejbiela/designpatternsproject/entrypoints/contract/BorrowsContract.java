package io.github.maciejbiela.designpatternsproject.entrypoints.contract;

import io.github.maciejbiela.designpatternsproject.core.model.borrow.Borrow;

import java.util.List;

public interface BorrowsContract {
    List<Borrow> getAllBorrows();
}
