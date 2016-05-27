package io.github.maciejbiela.designpatternsproject.core.usecases.borrow.returnborrow;

import io.github.maciejbiela.designpatternsproject.core.model.Borrow;

public interface ReturnBorrowResponseHandler {
    void onResponse(Borrow borrow);
}
