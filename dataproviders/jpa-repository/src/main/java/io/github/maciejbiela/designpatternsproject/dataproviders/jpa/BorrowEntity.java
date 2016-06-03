package io.github.maciejbiela.designpatternsproject.dataproviders.jpa;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "Borrows")
public class BorrowEntity {
    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    private BorrowerEntity borrower;

    @OneToMany
    private List<ItemEntity> items;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BorrowerEntity getBorrower() {
        return borrower;
    }

    public void setBorrower(BorrowerEntity borrower) {
        this.borrower = borrower;
    }

    public List<ItemEntity> getItems() {
        return items;
    }

    public void setItems(List<ItemEntity> items) {
        this.items = items;
    }
}
