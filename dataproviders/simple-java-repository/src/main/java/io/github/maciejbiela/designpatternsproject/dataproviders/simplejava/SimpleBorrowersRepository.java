package io.github.maciejbiela.designpatternsproject.dataproviders.simplejava;

import io.github.maciejbiela.designpatternsproject.core.model.borrower.Borrower;
import io.github.maciejbiela.designpatternsproject.core.model.borrower.IndividualBorrower;
import io.github.maciejbiela.designpatternsproject.core.repositories.borrowers.BorrowersRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class SimpleBorrowersRepository implements BorrowersRepository {
    private static final List<Borrower> BORROWERS = new ArrayList<>();

    static {
        BORROWERS.add(new IndividualBorrower("Maciej"));
        BORROWERS.add(new IndividualBorrower("Wioletta"));
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
    public void update(Borrower borrower) {
        final Optional<Borrower> possiblyExistingBorrower = BORROWERS.stream()
                .filter(b -> b.getName().equals(borrower.getName()))
                .findFirst();
        if (possiblyExistingBorrower.isPresent()) {
            possiblyExistingBorrower.get().updateAccordingTo(borrower);
        } else {
            BORROWERS.add(borrower);
        }
    }
}
