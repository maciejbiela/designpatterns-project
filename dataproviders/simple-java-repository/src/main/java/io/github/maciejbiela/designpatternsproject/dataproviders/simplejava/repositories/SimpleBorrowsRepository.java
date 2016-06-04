package io.github.maciejbiela.designpatternsproject.dataproviders.simplejava.repositories;

import io.github.maciejbiela.designpatternsproject.core.model.borrow.Borrow;
import io.github.maciejbiela.designpatternsproject.core.repositories.borrow.BorrowsRepository;
import io.github.maciejbiela.designpatternsproject.dataproviders.simplejava.model.BorrowImpl;

import java.util.ArrayList;
import java.util.List;

public class SimpleBorrowsRepository extends AbstractRepository<Borrow>
        implements BorrowsRepository {
    private static final List<Borrow> BORROWS = new ArrayList<>();

    @Override
    List<Borrow> getRepositoryList() {
        return BORROWS;
    }

    @Override
    void update(Borrow actual, Borrow accordingTo) {
        actual.setBorrower(accordingTo.getBorrower());
        actual.setItems(accordingTo.getItems());
        actual.setBorrowDate(accordingTo.getBorrowDate());
        actual.setReturnDate(accordingTo.getReturnDate());
    }

    @Override
    public Borrow createNewBorrow() {
        return new BorrowImpl((long) (BORROWS.size() + 1));
    }
}
