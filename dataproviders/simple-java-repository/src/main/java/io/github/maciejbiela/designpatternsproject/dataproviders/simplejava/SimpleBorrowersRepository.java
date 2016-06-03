package io.github.maciejbiela.designpatternsproject.dataproviders.simplejava;

import io.github.maciejbiela.designpatternsproject.core.model.borrower.Borrower;
import io.github.maciejbiela.designpatternsproject.core.repositories.borrowers.BorrowersRepository;

import java.util.ArrayList;
import java.util.List;

public class SimpleBorrowersRepository implements BorrowersRepository {
    private static final List<Borrower> BORROWERS = new ArrayList<>();

    static {

    }

    @Override
    public Borrower get(Long id) {
        return BORROWERS.stream()
                .filter(borrower -> borrower.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<Borrower> getAll() {
        return BORROWERS;
    }

    @Override
    public void update(Borrower borrower) {

    }
}
