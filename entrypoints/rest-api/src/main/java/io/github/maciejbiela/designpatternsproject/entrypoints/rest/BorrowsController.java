package io.github.maciejbiela.designpatternsproject.entrypoints.rest;

import io.github.maciejbiela.designpatternsproject.core.model.borrow.Borrow;
import io.github.maciejbiela.designpatternsproject.core.usecases.borrow.get.all.GetAllBorrowsUseCase;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BorrowsController {
    private GetAllBorrowsUseCase getAllBorrowsUseCase;

    public BorrowsController(GetAllBorrowsUseCase getAllBorrowsUseCase) {
        this.getAllBorrowsUseCase = getAllBorrowsUseCase;
    }

    @RequestMapping("/borrows")
    public List<Borrow> getAllBorrows() {
        return getAllBorrowsUseCase.execute();
    }
}
