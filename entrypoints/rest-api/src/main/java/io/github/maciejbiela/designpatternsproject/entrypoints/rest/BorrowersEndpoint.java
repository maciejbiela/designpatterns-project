package io.github.maciejbiela.designpatternsproject.entrypoints.rest;

import io.github.maciejbiela.designpatternsproject.core.model.borrower.Borrower;
import io.github.maciejbiela.designpatternsproject.core.model.item.Item;
import io.github.maciejbiela.designpatternsproject.core.usecases.borrower.BorrowerUseCases;
import io.github.maciejbiela.designpatternsproject.core.usecases.item.ItemUseCases;
import io.github.maciejbiela.designpatternsproject.entrypoints.contract.BorrowersContract;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static java.util.stream.Collectors.toList;

@RestController
public class BorrowersEndpoint implements BorrowersContract {
    private BorrowerUseCases borrowerUseCases;
    private ItemUseCases itemsUseCases;

    public BorrowersEndpoint(BorrowerUseCases borrowerUseCases, ItemUseCases itemsUseCases) {
        this.borrowerUseCases = borrowerUseCases;
        this.itemsUseCases = itemsUseCases;
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

    @RequestMapping(method = RequestMethod.POST, value = "/borrower/{id}", consumes = {"application/json"})
    public void borrowItems(@PathVariable Long id, @RequestBody List<Long> itemIds) {
        final Borrower borrower = borrowerUseCases.getSingleBorrowerUseCase().execute(id);
        final List<Item> items = itemIds.stream()
                .map(itemId -> itemsUseCases.getSingleItemUseCase().execute(itemId))
                .collect(toList());
        borrowerUseCases.borrowItemsUseCase().execute(borrower, items);
    }
}
