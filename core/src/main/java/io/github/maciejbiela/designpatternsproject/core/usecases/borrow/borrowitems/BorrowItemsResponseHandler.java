package io.github.maciejbiela.designpatternsproject.core.usecases.borrow.borrowitems;

import io.github.maciejbiela.designpatternsproject.core.model.Borrow;

public interface BorrowItemsResponseHandler {
    void onResponse(Borrow borrow);
}
