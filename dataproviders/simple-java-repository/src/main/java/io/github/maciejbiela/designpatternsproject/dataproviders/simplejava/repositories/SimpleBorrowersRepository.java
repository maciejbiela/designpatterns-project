package io.github.maciejbiela.designpatternsproject.dataproviders.simplejava.repositories;

import io.github.maciejbiela.designpatternsproject.core.model.borrower.Borrower;
import io.github.maciejbiela.designpatternsproject.core.repositories.borrowers.BorrowersRepository;
import io.github.maciejbiela.designpatternsproject.dataproviders.simplejava.model.BorrowerImpl;

import java.util.ArrayList;
import java.util.List;

import static io.github.maciejbiela.designpatternsproject.core.model.borrower.BorrowerType.INDIVIDUAL;
import static io.github.maciejbiela.designpatternsproject.core.model.borrower.BorrowerType.ORGANIZATION;

public class SimpleBorrowersRepository extends AbstractRepository<Borrower>
        implements BorrowersRepository {
    private static final List<Borrower> BORROWERS = new ArrayList<>();

    static {
        BORROWERS.add(new BorrowerImpl("Maciej Biela", INDIVIDUAL));
        BORROWERS.add(new BorrowerImpl("Jan Kowalski", INDIVIDUAL));
        BORROWERS.add(new BorrowerImpl("Koło studentów", ORGANIZATION));
        for (int i = 0; i < BORROWERS.size(); i++) {
            BORROWERS.get(i).setId((long) (i + 1));
        }
    }

    @Override
    List<Borrower> getRepositoryList() {
        return BORROWERS;
    }

    @Override
    void update(Borrower actual, Borrower accordingTo) {
        actual.setName(accordingTo.getName());
        actual.setType(accordingTo.getType());
    }
}
