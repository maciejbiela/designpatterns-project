package io.github.maciejbiela.designpatternsproject.entrypoints.rest;

import io.github.maciejbiela.designpatternsproject.core.model.borrower.Borrower;
import io.github.maciejbiela.designpatternsproject.core.usecases.borrower.BorrowerUseCases;
import io.github.maciejbiela.designpatternsproject.entrypoints.contract.BorrowersContract;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BorrowersEndpoint implements BorrowersContract {
    private BorrowerUseCases borrowerUseCases;

    public BorrowersEndpoint(BorrowerUseCases borrowerUseCases) {
        this.borrowerUseCases = borrowerUseCases;
    }

    @Override
    @RequestMapping(method = RequestMethod.GET, value = "/borrowers")
    public List<Borrower> getAllBorrowers() {
        return borrowerUseCases.getAllBorrowersUseCase().execute();
    }

    @Override
    @RequestMapping(method = RequestMethod.GET, value = "/borrower/{id}")
    public Borrower getSingleBorrower(@PathVariable Long id) {
        return borrowerUseCases.getSingleBorrowerUseCase().execute(id);
    }

    @Override
    @RequestMapping(method = RequestMethod.POST, value = "/borrower", consumes = {"application/json"})
    public void update(@RequestBody Borrower borrower) {
        borrowerUseCases.addBorrowerUseCase().execute(borrower);
    }
}
