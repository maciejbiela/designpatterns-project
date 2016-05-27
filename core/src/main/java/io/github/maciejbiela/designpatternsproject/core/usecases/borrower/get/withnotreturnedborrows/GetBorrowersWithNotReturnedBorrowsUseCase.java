package io.github.maciejbiela.designpatternsproject.core.usecases.borrower.get.withnotreturnedborrows;

import io.github.maciejbiela.designpatternsproject.core.model.Borrow;
import io.github.maciejbiela.designpatternsproject.core.model.Borrower;
import io.github.maciejbiela.designpatternsproject.core.repositories.borrow.BorrowsRepository;

import java.util.List;

import static java.util.stream.Collectors.toList;

public class GetBorrowersWithNotReturnedBorrowsUseCase {
    private final BorrowsRepository borrowsRepository;

    public GetBorrowersWithNotReturnedBorrowsUseCase(BorrowsRepository borrowsRepository) {
        this.borrowsRepository = borrowsRepository;
    }

    public List<Borrower> getBorrowersWithNotReturnedBorrows() {
        final List<Borrow> allBorrows = borrowsRepository.getAll();
        final List<Borrow> notReturnedBorrows = allBorrows.stream()
                .filter(borrow -> borrow.getReturnDate() == null)
                .collect(toList());
        return notReturnedBorrows.stream()
                .map(Borrow::getBorrower)
                .distinct()
                .collect(toList());
    }
}
