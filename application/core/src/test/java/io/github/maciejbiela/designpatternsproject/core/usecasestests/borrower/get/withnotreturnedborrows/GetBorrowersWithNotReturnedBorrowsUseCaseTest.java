package io.github.maciejbiela.designpatternsproject.core.usecasestests.borrower.get.withnotreturnedborrows;

import io.github.maciejbiela.designpatternsproject.core.model.borrow.Borrow;
import io.github.maciejbiela.designpatternsproject.core.model.borrow.BorrowImpl;
import io.github.maciejbiela.designpatternsproject.core.model.borrower.Borrower;
import io.github.maciejbiela.designpatternsproject.core.model.borrower.BorrowerImpl;
import io.github.maciejbiela.designpatternsproject.core.model.borrower.BorrowerType;
import io.github.maciejbiela.designpatternsproject.core.repositories.borrow.BorrowsRepository;
import io.github.maciejbiela.designpatternsproject.core.usecases.borrower.get.withnotreturnedborrows.GetBorrowersWithNotReturnedBorrowsUseCase;
import org.junit.Test;

import java.time.LocalDate;
import java.util.List;

import static java.util.Arrays.asList;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class GetBorrowersWithNotReturnedBorrowsUseCaseTest {
    private BorrowsRepository borrowsRepository = mock(BorrowsRepository.class);

    private GetBorrowersWithNotReturnedBorrowsUseCase getBorrowersWithNotReturnedBorrowsUseCase = new GetBorrowersWithNotReturnedBorrowsUseCase(borrowsRepository);
    private long BORROW_ID = 1;

    @Test
    public void returnsOnlyBorrowersWithNotReturnedBorrows() {
        final List<Borrower> expectedBorrowers = givenSomeBorrowersWithNotReturnedBorrowsInRepository();

        final List<Borrower> actualBorrowers = getBorrowersWithNotReturnedBorrowsUseCase.execute();

        assertThat(actualBorrowers, containsInAnyOrder(expectedBorrowers.toArray()));
    }

    private List<Borrower> givenSomeBorrowersWithNotReturnedBorrowsInRepository() {
        final Borrower janKowalski = new BorrowerImpl("Jan Kowalski", BorrowerType.INDIVIDUAL);
        final Borrower koloStudentow = new BorrowerImpl("Koło Studentów Informatyki", BorrowerType.ORGANIZATION);
        final Borrower tomaszKwiatkowski = new BorrowerImpl("Tomasz Kwiatkowski", BorrowerType.INDIVIDUAL);
        final Borrow returnedBorrow = getReturnedBorrow(janKowalski);
        final Borrow notReturnedBorrow1 = getNotReturnedBorrow(koloStudentow);
        final Borrow notReturnedBorrow2 = getNotReturnedBorrow(tomaszKwiatkowski);
        when(borrowsRepository.getAll()).thenReturn(asList(returnedBorrow, notReturnedBorrow1, notReturnedBorrow2));
        return asList(koloStudentow, tomaszKwiatkowski);
    }

    private Borrow getReturnedBorrow(Borrower borrower) {
        final Borrow returnedBorrow = new BorrowImpl(BORROW_ID);
        BORROW_ID++;
        returnedBorrow.setBorrower(borrower);
        returnedBorrow.setBorrowDate(LocalDate.of(2016, 5, 1));
        returnedBorrow.setReturnDate(LocalDate.of(2016, 5, 15));
        return returnedBorrow;
    }

    private Borrow getNotReturnedBorrow(Borrower borrower) {
        final Borrow returnedBorrow = new BorrowImpl(BORROW_ID);
        BORROW_ID++;
        returnedBorrow.setBorrower(borrower);
        returnedBorrow.setBorrowDate(LocalDate.of(2016, 5, 1));
        return returnedBorrow;
    }
}