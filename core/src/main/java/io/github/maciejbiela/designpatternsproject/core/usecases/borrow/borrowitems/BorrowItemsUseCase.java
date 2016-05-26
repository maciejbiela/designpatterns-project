package io.github.maciejbiela.designpatternsproject.core.usecases.borrow.borrowitems;

import io.github.maciejbiela.designpatternsproject.core.model.Borrow;
import io.github.maciejbiela.designpatternsproject.core.model.Borrower;
import io.github.maciejbiela.designpatternsproject.core.model.Item;
import io.github.maciejbiela.designpatternsproject.core.repositories.BorrowersRepository;
import io.github.maciejbiela.designpatternsproject.core.repositories.BorrowsRepository;
import io.github.maciejbiela.designpatternsproject.core.repositories.ItemsRepository;

import java.time.LocalDate;
import java.util.List;

public class BorrowItemsUseCase {
    private final BorrowersRepository borrowersRepository;
    private final BorrowsRepository borrowsRepository;
    private final ItemsRepository itemsRepository;

    public BorrowItemsUseCase(BorrowersRepository borrowersRepository, BorrowsRepository borrowsRepository, ItemsRepository itemsRepository) {
        this.borrowersRepository = borrowersRepository;
        this.borrowsRepository = borrowsRepository;
        this.itemsRepository = itemsRepository;
    }

    public void borrowItems(BorrowItemsRequest request, BorrowItemsResponseHandler responseHandler, BorrowItemsRequestValidator validator) {
        validator.validate(request, borrowersRepository, itemsRepository);
        final Borrow borrow = constructBorrow(request);
        borrowsRepository.store(borrow);
        responseHandler.onResponse(borrow);
    }

    private Borrow constructBorrow(BorrowItemsRequest request) {
        final Borrower borrower = request.getBorrower();
        final List<Item> items = request.getItems();
        final LocalDate now = LocalDate.now();
        return new Borrow(borrower, items, now);
    }
}
