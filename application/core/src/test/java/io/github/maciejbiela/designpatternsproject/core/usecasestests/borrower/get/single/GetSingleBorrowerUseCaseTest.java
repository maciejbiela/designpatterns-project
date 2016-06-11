package io.github.maciejbiela.designpatternsproject.core.usecasestests.borrower.get.single;

import io.github.maciejbiela.designpatternsproject.core.model.borrower.Borrower;
import io.github.maciejbiela.designpatternsproject.core.model.borrower.BorrowerImpl;
import io.github.maciejbiela.designpatternsproject.core.model.borrower.BorrowerType;
import io.github.maciejbiela.designpatternsproject.core.repositories.borrowers.BorrowersRepository;
import io.github.maciejbiela.designpatternsproject.core.usecases.borrower.get.single.BorrowerNotFoundException;
import io.github.maciejbiela.designpatternsproject.core.usecases.borrower.get.single.GetSingleBorrowerUseCase;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class GetSingleBorrowerUseCaseTest {
    private static final long EXISTING_ID = 3L;
    private static final long NON_EXISTING_ID = 10L;

    private BorrowersRepository borrowersRepository = mock(BorrowersRepository.class);

    private GetSingleBorrowerUseCase getSingleBorrowerUseCase = new GetSingleBorrowerUseCase(borrowersRepository);

    @Test
    public void returnsCorrectBorrowerForExistingId() {
        final Borrower expectedBorrower = givenIdThatCorrespondsToABorrower();

        final Borrower actualBorrower = getSingleBorrowerUseCase.execute(EXISTING_ID);

        assertEquals(expectedBorrower, actualBorrower);
    }

    @Test
    public void throwsExceptionWhenTryingToAccessInvalidId() {
        givenIdThatDoesNotExist();

        assertThatExceptionOfType(BorrowerNotFoundException.class)
                .isThrownBy(() -> getSingleBorrowerUseCase.execute(NON_EXISTING_ID));
    }

    private Borrower givenIdThatCorrespondsToABorrower() {
        final Borrower janKowalski = new BorrowerImpl("Jan Kowalski", BorrowerType.INDIVIDUAL);
        janKowalski.setId(EXISTING_ID);
        when(borrowersRepository.get(EXISTING_ID)).thenReturn(janKowalski);
        return janKowalski;
    }

    private void givenIdThatDoesNotExist() {
        when(borrowersRepository.get(NON_EXISTING_ID)).thenThrow(new BorrowerNotFoundException());
    }
}