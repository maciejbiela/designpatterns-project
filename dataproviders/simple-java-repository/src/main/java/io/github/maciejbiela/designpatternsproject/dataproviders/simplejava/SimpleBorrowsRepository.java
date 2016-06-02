package io.github.maciejbiela.designpatternsproject.dataproviders.simplejava;

import io.github.maciejbiela.designpatternsproject.core.model.borrow.Borrow;
import io.github.maciejbiela.designpatternsproject.core.repositories.borrow.BorrowsRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class SimpleBorrowsRepository implements BorrowsRepository {
    private static final List<Borrow> BORROWS = new ArrayList<>();

    @Override
    public List<Borrow> getAll() {
        return BORROWS;
    }

    @Override
    public void update(Borrow borrow) {
        final Optional<Borrow> possiblyExistingBorrow = BORROWS.stream()
                .filter(b -> b.getId().equals(borrow.getId()))
                .findFirst();
        if (possiblyExistingBorrow.isPresent()) {
            possiblyExistingBorrow.get().updateAccordingTo(borrow);
        } else {
            borrow.setId((long) BORROWS.size());
            BORROWS.add(borrow);
        }
    }
}
