package io.github.maciejbiela.designpatternsproject.dataproviders.simplejava;

import io.github.maciejbiela.designpatternsproject.core.model.Borrower;
import io.github.maciejbiela.designpatternsproject.core.repositories.BorrowersRepository;

import java.util.ArrayList;
import java.util.List;

public class SimpleBorrowersRepository implements BorrowersRepository {
    private static final List<Borrower> BORROWERS = new ArrayList<>();

    static {
        BORROWERS.add(new BorrowerEntity("Maciej"));
        BORROWERS.add(new BorrowerEntity("Wioletta"));
    }

    @Override
    public Borrower get(String name) {
        return BORROWERS.stream()
                .filter(borrower -> borrower.getName().equals(name))
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<Borrower> getAll() {
        return BORROWERS;
    }

    @Override
    public void store(Borrower borrower) {
        BORROWERS.add(borrower);
    }
}
