package io.github.maciejbiela.designpatternsproject.core.model.item;

public interface IItem {
    Long getId();

    void setId(Long id);

    String getName();

    void setName(String name);

    boolean isAvailable();

    void setAvailable(boolean available);

    ItemType getType();

    void setType(ItemType type);

    //void updateAccordingTo(Item item);
}
