package io.github.maciejbiela.designpatternsproject.dataproviders.jpa;

import io.github.maciejbiela.designpatternsproject.core.model.item.IItem;
import io.github.maciejbiela.designpatternsproject.core.model.item.ItemType;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Items")
public class ItemEntity implements IItem {
    @Id
    @GeneratedValue
    private Long id;

    @Basic
    private String name;

    @Basic
    private boolean available;

    @Basic
    private ItemType type;


    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean isAvailable() {
        return available;
    }

    @Override
    public void setAvailable(boolean available) {
        this.available = available;
    }

    public ItemType getType() {
        return type;
    }

    public void setType(ItemType itemType) {
        this.type = itemType;
    }
}
