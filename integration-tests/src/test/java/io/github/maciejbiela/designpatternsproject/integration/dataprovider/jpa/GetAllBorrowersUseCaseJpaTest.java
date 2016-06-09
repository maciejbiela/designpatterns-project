package io.github.maciejbiela.designpatternsproject.integration.dataprovider.jpa;

import io.github.maciejbiela.designpatternsproject.core.model.borrower.Borrower;
import io.github.maciejbiela.designpatternsproject.core.model.borrower.BorrowerType;
import io.github.maciejbiela.designpatternsproject.core.repositories.borrowers.BorrowersRepository;
import io.github.maciejbiela.designpatternsproject.core.usecases.borrower.get.all.GetAllBorrowersUseCase;
import io.github.maciejbiela.designpatternsproject.dataproviders.jpa.model.BorrowerEntity;
import io.github.maciejbiela.designpatternsproject.dataproviders.jpa.repositories.JpaBorrowersRepository;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

import static java.util.Arrays.asList;
import static org.hamcrest.Matchers.containsInAnyOrder;

public class GetAllBorrowersUseCaseJpaTest {

    BorrowersRepository borrowersRepository = new JpaBorrowersRepository();
    GetAllBorrowersUseCase getAllBorrowersUseCase = new GetAllBorrowersUseCase(borrowersRepository);

    @Test
    public void getsAllBorrowersFromRepository() {
        List<Borrower> expectedBorrowers = givenSomeBorrowersInRepository();

        final List<Borrower> actualBorrowers = getAllBorrowersUseCase.execute();

        Assert.assertThat(actualBorrowers, containsInAnyOrder(expectedBorrowers.toArray()));
    }

    private List<Borrower> givenSomeBorrowersInRepository() {
        BorrowerEntity borrower1 = new BorrowerEntity();
        borrower1.setName("Jan Kowalski");
        borrower1.setType(BorrowerType.INDIVIDUAL);

        BorrowerEntity borrower2 = new BorrowerEntity();
        borrower2.setName("Koło Studentów Informatyki");
        borrower2.setType(BorrowerType.ORGANIZATION);

        borrowersRepository.update(borrower1);
        borrowersRepository.update(borrower2);

        borrower1.setId(1L);
        borrower2.setId(2L);
        return asList(borrower1, borrower2);
    }
}
