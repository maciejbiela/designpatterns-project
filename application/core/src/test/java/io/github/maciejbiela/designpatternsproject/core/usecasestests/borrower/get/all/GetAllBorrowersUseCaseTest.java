package io.github.maciejbiela.designpatternsproject.core.usecasestests.borrower.get.all;

import io.github.maciejbiela.designpatternsproject.core.model.borrower.Borrower;
import io.github.maciejbiela.designpatternsproject.core.model.borrower.BorrowerImpl;
import io.github.maciejbiela.designpatternsproject.core.model.borrower.BorrowerType;
import io.github.maciejbiela.designpatternsproject.core.repositories.borrowers.BorrowersRepository;
import io.github.maciejbiela.designpatternsproject.core.usecases.borrower.get.all.GetAllBorrowersUseCase;
import org.junit.Test;

import java.util.List;

import static java.util.Arrays.asList;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class GetAllBorrowersUseCaseTest {
    private final BorrowersRepository borrowersRepository = mock(BorrowersRepository.class);

    private GetAllBorrowersUseCase getAllBorrowersUseCase = new GetAllBorrowersUseCase(borrowersRepository);

    @Test
    public void returnsAllBorrowersFromRepository() {
        final List<Borrower> expectedBorrowers = givenSomeBorrowersInRepository();

        final List<Borrower> actualBorrowers = getAllBorrowersUseCase.execute();

        assertThat(actualBorrowers, containsInAnyOrder(expectedBorrowers.toArray()));
    }

    private List<Borrower> givenSomeBorrowersInRepository() {
        Borrower janKowalski = new BorrowerImpl("Jan Kowalski", BorrowerType.INDIVIDUAL);
        Borrower koloStudentow = new BorrowerImpl("Koło Studentów Informatyki", BorrowerType.ORGANIZATION);
        final List<Borrower> borrowers = asList(janKowalski, koloStudentow);
        when(borrowersRepository.getAll()).thenReturn(borrowers);
        return borrowers;
    }
}