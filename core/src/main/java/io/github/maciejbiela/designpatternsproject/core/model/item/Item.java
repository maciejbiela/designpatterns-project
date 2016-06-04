package io.github.maciejbiela.designpatternsproject.core.model.item;

import io.github.maciejbiela.designpatternsproject.core.model.WithId;

public interface Item extends WithId {
    String getName();

    void setName(String name);

    boolean isAvailable();

    void setAvailable(boolean available);

    ItemType getType();

    void setType(ItemType type);
}
