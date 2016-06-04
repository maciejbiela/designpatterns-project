package io.github.maciejbiela.designpatternsproject.configuration;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.module.SimpleModule;
import io.github.maciejbiela.designpatternsproject.core.model.borrow.Borrow;
import io.github.maciejbiela.designpatternsproject.core.model.borrower.Borrower;
import io.github.maciejbiela.designpatternsproject.core.model.item.Item;
import io.github.maciejbiela.designpatternsproject.dataproviders.jpa.BorrowEntity;
import io.github.maciejbiela.designpatternsproject.dataproviders.jpa.BorrowerEntity;
import io.github.maciejbiela.designpatternsproject.dataproviders.jpa.ItemEntity;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JsonDeserializationConfiguration extends SimpleModule {
    @Override
    public void setupModule(SetupContext context) {
        context.setMixInAnnotations(Borrow.class, BorrowMixIn.class);
        context.setMixInAnnotations(Borrower.class, BorrowerMixIn.class);
        context.setMixInAnnotations(Item.class, ItemMixIn.class);
    }

    @JsonDeserialize(as = BorrowEntity.class)
    private class BorrowMixIn {
    }

    @JsonDeserialize(as = BorrowerEntity.class)
    private class BorrowerMixIn {
    }

    @JsonDeserialize(as = ItemEntity.class)
    private class ItemMixIn {
    }

}
