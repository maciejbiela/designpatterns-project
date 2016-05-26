package io.github.maciejbiela.designpatternsproject.core;

import java.time.LocalDate;

public interface BorrowItem extends Item {
    LocalDate getBorrowDate();
}
