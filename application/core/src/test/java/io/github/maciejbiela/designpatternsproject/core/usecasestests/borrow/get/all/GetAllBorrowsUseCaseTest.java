package io.github.maciejbiela.designpatternsproject.core.usecasestests.borrow.get.all;

import io.github.maciejbiela.designpatternsproject.core.model.borrow.Borrow;
import io.github.maciejbiela.designpatternsproject.core.model.borrow.BorrowImpl;
import io.github.maciejbiela.designpatternsproject.core.repositories.borrow.BorrowsRepository;
import io.github.maciejbiela.designpatternsproject.core.usecases.borrow.get.all.GetAllBorrowsUseCase;
import org.junit.Test;

import java.util.List;

import static java.util.Arrays.asList;
import static java.util.Collections.emptyList;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class GetAllBorrowsUseCaseTest {
    private BorrowsRepository borrowsRepository = mock(BorrowsRepository.class);

    private GetAllBorrowsUseCase getAllBorrowsUseCase = new GetAllBorrowsUseCase(borrowsRepository);

    @Test
    public void returnsEmptyBorrowsListWhenNoBorrowInRepository() {
        List<Borrow> expectedBorrows = givenNoBorrows();

        List<Borrow> actualBorrows = getAllBorrowsUseCase.execute();

        assertThat(actualBorrows).isEqualTo(expectedBorrows);
    }

    @Test
    public void returnsAllBorrowsFromRepository() {
        List<Borrow> expectedBorrows = givenBorrows();

        List<Borrow> actualBorrows = getAllBorrowsUseCase.execute();

        assertThat(actualBorrows).isEqualTo(expectedBorrows);
    }

    private List<Borrow> givenNoBorrows() {
        final List<Borrow> listWithNoBorrows = emptyList();
        when(borrowsRepository.getAll()).thenReturn(listWithNoBorrows);
        return listWithNoBorrows;
    }

    private List<Borrow> givenBorrows() {
        final List<Borrow> listWithSomeBorrows = asList(
                new BorrowImpl(1L),
                new BorrowImpl(2L),
                new BorrowImpl(3L)
        );
        when(borrowsRepository.getAll()).thenReturn(listWithSomeBorrows);
        return listWithSomeBorrows;
    }
}