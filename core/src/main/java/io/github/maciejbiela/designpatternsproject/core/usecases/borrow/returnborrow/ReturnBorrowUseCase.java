package io.github.maciejbiela.designpatternsproject.core.usecases.borrow.returnborrow;

import io.github.maciejbiela.designpatternsproject.core.model.Borrow;
import io.github.maciejbiela.designpatternsproject.core.model.Item;
import io.github.maciejbiela.designpatternsproject.core.repositories.BorrowsRepository;
import io.github.maciejbiela.designpatternsproject.core.repositories.ItemsRepository;

import java.time.LocalDate;
import java.util.List;

public class ReturnBorrowUseCase {
    private final BorrowsRepository borrowsRepository;
    private final ItemsRepository itemsRepository;

    public ReturnBorrowUseCase(BorrowsRepository borrowsRepository, ItemsRepository itemsRepository) {
        this.borrowsRepository = borrowsRepository;
        this.itemsRepository = itemsRepository;
    }

    public void returnBorrow(Borrow borrow, ReturnBorrowResponseHandler returnBorrowResponseHandler) {
        final List<Item> items = borrow.getItems();
        for (Item item : items) {
            itemsRepository.returnItem(item.getId());
        }
        borrow.setReturnDate(LocalDate.now());
        borrowsRepository.update(borrow);
        returnBorrowResponseHandler.onResponse(borrow);
    }
}
