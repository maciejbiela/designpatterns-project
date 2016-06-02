package io.github.maciejbiela.designpatternsproject.entrypoints.rest;

import io.github.maciejbiela.designpatternsproject.core.model.borrow.Borrow;
import io.github.maciejbiela.designpatternsproject.core.usecases.borrow.BorrowUseCases;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BorrowsEndpoint {
    private BorrowUseCases borrowUseCases;

    public BorrowsEndpoint(BorrowUseCases borrowUseCases) {
        this.borrowUseCases = borrowUseCases;
    }

    @RequestMapping("/borrows")
    public List<Borrow> getAllBorrows() {
        return borrowUseCases.getAllBorrowsUseCase().execute();
    }
}
