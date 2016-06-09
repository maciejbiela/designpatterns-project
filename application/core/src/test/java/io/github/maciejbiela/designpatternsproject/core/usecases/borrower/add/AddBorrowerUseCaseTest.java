package io.github.maciejbiela.designpatternsproject.core.usecases.borrower.add;

import io.github.maciejbiela.designpatternsproject.core.model.borrower.Borrower;
import io.github.maciejbiela.designpatternsproject.core.model.borrower.BorrowerImpl;
import io.github.maciejbiela.designpatternsproject.core.repositories.borrowers.BorrowersRepository;
import org.junit.Test;

import static io.github.maciejbiela.designpatternsproject.core.model.borrower.BorrowerType.INDIVIDUAL;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class AddBorrowerUseCaseTest {
    private BorrowersRepository borrowersRepository = mock(BorrowersRepository.class);

    private AddBorrowerUseCase addBorrowerUseCase = new AddBorrowerUseCase(borrowersRepository);

    @Test
    public void addsBorrowerToRepository() {
        Borrower borrower = new BorrowerImpl("Jan Kowalski", INDIVIDUAL);
        addBorrowerUseCase.execute(borrower);
        verify(borrowersRepository).update(borrower);
    }
}