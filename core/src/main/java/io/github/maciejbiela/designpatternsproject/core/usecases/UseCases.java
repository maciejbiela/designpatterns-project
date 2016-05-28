package io.github.maciejbiela.designpatternsproject.core.usecases;

import io.github.maciejbiela.designpatternsproject.core.repositories.borrow.BorrowsRepository;
import io.github.maciejbiela.designpatternsproject.core.repositories.borrowers.BorrowersRepository;
import io.github.maciejbiela.designpatternsproject.core.repositories.items.ItemsRepository;
import io.github.maciejbiela.designpatternsproject.core.usecases.borrow.borrowitems.BorrowItemsUseCase;
import io.github.maciejbiela.designpatternsproject.core.usecases.borrow.get.all.GetAllBorrowsUseCase;
import io.github.maciejbiela.designpatternsproject.core.usecases.borrow.returnborrow.ReturnBorrowUseCase;
import io.github.maciejbiela.designpatternsproject.core.usecases.borrower.add.AddBorrowerUseCase;
import io.github.maciejbiela.designpatternsproject.core.usecases.borrower.get.all.GetAllBorrowersUseCase;
import io.github.maciejbiela.designpatternsproject.core.usecases.borrower.get.single.GetSingleBorrowerUseCase;
import io.github.maciejbiela.designpatternsproject.core.usecases.borrower.get.withnotreturnedborrows.GetBorrowersWithNotReturnedBorrowsUseCase;
import io.github.maciejbiela.designpatternsproject.core.usecases.item.add.AddItemUseCase;
import io.github.maciejbiela.designpatternsproject.core.usecases.item.get.all.GetAllItemsUseCase;
import io.github.maciejbiela.designpatternsproject.core.usecases.item.get.available.GetAvailableItemsUseCase;
import io.github.maciejbiela.designpatternsproject.core.usecases.item.get.single.GetSingleItemUseCase;
import io.github.maciejbiela.designpatternsproject.core.usecases.item.get.unavailable.GetUnavailableItemsUseCase;

public class UseCases {
    private BorrowersRepository borrowersRepository;
    private BorrowsRepository borrowsRepository;
    private ItemsRepository itemsRepository;

    public UseCases(BorrowersRepository borrowersRepository, BorrowsRepository borrowsRepository, ItemsRepository itemsRepository) {
        this.borrowersRepository = borrowersRepository;
        this.borrowsRepository = borrowsRepository;
        this.itemsRepository = itemsRepository;
    }

    public void setItemsRepository(ItemsRepository itemsRepository) {
        this.itemsRepository = itemsRepository;
    }

    public BorrowItemsUseCase borrowItemsUseCase() {
        return new BorrowItemsUseCase(borrowersRepository, borrowsRepository, itemsRepository);
    }

    public GetAllBorrowsUseCase getAllBorrowsUseCase() {
        return new GetAllBorrowsUseCase(borrowsRepository);
    }

    public ReturnBorrowUseCase returnBorrowUseCase() {
        return new ReturnBorrowUseCase(borrowersRepository, borrowsRepository, itemsRepository);
    }

    public AddBorrowerUseCase addBorrowerUseCase() {
        return new AddBorrowerUseCase(borrowersRepository);
    }

    public GetAllBorrowersUseCase getAllBorrowersUseCase() {
        return new GetAllBorrowersUseCase(borrowersRepository);
    }

    public GetSingleBorrowerUseCase getSingleBorrowerUseCase() {
        return new GetSingleBorrowerUseCase(borrowersRepository);
    }

    public GetBorrowersWithNotReturnedBorrowsUseCase getBorrowersWithNotReturnedBorrowsUseCase() {
        return new GetBorrowersWithNotReturnedBorrowsUseCase(borrowsRepository);
    }

    public AddItemUseCase addItemUseCase() {
        return new AddItemUseCase(itemsRepository);
    }

    public GetAllItemsUseCase getAllItemsUseCase() {
        return new GetAllItemsUseCase(itemsRepository);
    }

    public GetAvailableItemsUseCase getAvailableItemsUseCase() {
        return new GetAvailableItemsUseCase(itemsRepository);
    }

    public GetSingleItemUseCase getSingleItemUseCase() {
        return new GetSingleItemUseCase(itemsRepository);
    }

    public GetUnavailableItemsUseCase getUnavailableItemsUseCase() {
        return new GetUnavailableItemsUseCase(itemsRepository);
    }
}
