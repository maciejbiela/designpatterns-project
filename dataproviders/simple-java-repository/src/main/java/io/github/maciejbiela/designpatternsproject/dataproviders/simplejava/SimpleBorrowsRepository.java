package io.github.maciejbiela.designpatternsproject.dataproviders.simplejava;

import io.github.maciejbiela.designpatternsproject.core.model.Borrow;
import io.github.maciejbiela.designpatternsproject.core.repositories.borrow.BorrowsRepository;

import java.util.ArrayList;
import java.util.List;

public class SimpleBorrowsRepository implements BorrowsRepository {
    private static final List<Borrow> BORROWS = new ArrayList<>();

    @Override
    public List<Borrow> getAll() {
        return BORROWS;
    }

    @Override
    public void update(Borrow borrow) {
        BORROWS.add(borrow);
    }
}
