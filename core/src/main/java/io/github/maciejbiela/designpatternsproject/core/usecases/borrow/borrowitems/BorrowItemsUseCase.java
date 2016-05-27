package io.github.maciejbiela.designpatternsproject.core.usecases.borrow.borrowitems;

import io.github.maciejbiela.designpatternsproject.core.model.Borrow;
import io.github.maciejbiela.designpatternsproject.core.model.Borrower;
import io.github.maciejbiela.designpatternsproject.core.model.Item;
import io.github.maciejbiela.designpatternsproject.core.repositories.borrow.BorrowsRepository;
import io.github.maciejbiela.designpatternsproject.core.repositories.borrowers.BorrowersRepository;
import io.github.maciejbiela.designpatternsproject.core.repositories.items.ItemsRepository;

import java.time.LocalDate;
import java.util.List;

public class BorrowItemsUseCase {
    private final BorrowersRepository borrowersRepository;
    private final BorrowsRepository borrowsRepository;
    private final ItemsRepository itemsRepository;
    private final BorrowItemsRequestValidator validator;

    public BorrowItemsUseCase(BorrowersRepository borrowersRepository, BorrowsRepository borrowsRepository, ItemsRepository itemsRepository, BorrowItemsRequestValidator validator) {
        this.borrowersRepository = borrowersRepository;
        this.borrowsRepository = borrowsRepository;
        this.itemsRepository = itemsRepository;
        this.validator = validator;
    }

    public void borrowItems(BorrowItemsRequest request, BorrowItemsResponseHandler responseHandler) {
        validator.validate(request, borrowersRepository, itemsRepository);
        final Borrow borrow = constructBorrow(request);
        borrowsRepository.update(borrow);
        responseHandler.onResponse(borrow);
    }

    private Borrow constructBorrow(BorrowItemsRequest request) {
        final Long id = borrowsRepository.getNextId();
        final Borrower borrower = request.getBorrower();
        final List<Item> items = request.getItems();
        updateItemsStatuses(items);
        final LocalDate now = LocalDate.now();
        return new Borrow(id, borrower, items, now);
    }

    private void updateItemsStatuses(List<Item> items) {
        for (Item item : items) {
            itemsRepository.borrowItem(item.getId());
        }
    }
}
