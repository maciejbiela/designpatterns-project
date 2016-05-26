package io.github.maciejbiela.designpatternsproject.core.model;

import java.time.LocalDate;

public interface BorrowItem extends Item {
    LocalDate getBorrowDate();
}
