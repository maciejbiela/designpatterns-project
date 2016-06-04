package io.github.maciejbiela.designpatternsproject.dataproviders.jpa.model;

import io.github.maciejbiela.designpatternsproject.core.model.borrow.Borrow;
import io.github.maciejbiela.designpatternsproject.core.model.borrower.Borrower;
import io.github.maciejbiela.designpatternsproject.core.model.item.Item;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.time.LocalDate;
import java.util.List;

import static java.util.stream.Collectors.toList;

@Entity
@Table(name = "Borrows")
public class BorrowEntity implements Borrow {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    private BorrowerEntity borrower;

    @OneToMany(fetch = FetchType.EAGER)
    private List<ItemEntity> items;

    @Basic
    private LocalDate borrowDate;

    @Basic
    private LocalDate returnDate;

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public Borrower getBorrower() {
        return borrower;
    }

    @Override
    public void setBorrower(Borrower borrower) {
        this.borrower = (BorrowerEntity) borrower;
    }

    @Override
    public List<Item> getItems() {
        return items.stream()
                .map(itemEntity -> (Item) itemEntity)
                .collect(toList());
    }

    @Override
    public void setItems(List<Item> items) {
        this.items = items.stream()
                .map(item -> (ItemEntity) item)
                .collect(toList());
    }

    @Override
    public LocalDate getBorrowDate() {
        return borrowDate;
    }

    @Override
    public void setBorrowDate(LocalDate borrowDate) {
        this.borrowDate = borrowDate;
    }

    @Override
    public LocalDate getReturnDate() {
        return returnDate;
    }

    @Override
    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
    }
}
