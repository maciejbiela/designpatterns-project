package io.github.maciejbiela.designpatternsproject.entrypoints.rest;

import io.github.maciejbiela.designpatternsproject.core.model.borrower.Borrower;
import io.github.maciejbiela.designpatternsproject.core.usecases.borrower.BorrowerUseCases;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BorrowersEndpoint {
    private BorrowerUseCases borrowerUseCases;

    public BorrowersEndpoint(BorrowerUseCases borrowerUseCases) {
        this.borrowerUseCases = borrowerUseCases;
    }

    @RequestMapping("/borrowers")
    public List<Borrower> getAllBorrowers() {
        return borrowerUseCases.getAllBorrowersUseCase().execute();
    }

    @RequestMapping("/borrower/{id}")
    public Borrower getSingleBorrower(@PathVariable Long id) {
        return borrowerUseCases.getSingleBorrowerUseCase().execute(id);
    }
}
