package io.github.maciejbiela.designpatternsproject.configuration;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.module.SimpleModule;
import io.github.maciejbiela.designpatternsproject.core.model.borrow.Borrow;
import io.github.maciejbiela.designpatternsproject.core.model.borrow.BorrowImpl;
import io.github.maciejbiela.designpatternsproject.core.model.borrower.Borrower;
import io.github.maciejbiela.designpatternsproject.core.model.borrower.BorrowerImpl;
import io.github.maciejbiela.designpatternsproject.core.model.item.Item;
import io.github.maciejbiela.designpatternsproject.core.model.item.ItemImpl;
import io.github.maciejbiela.designpatternsproject.core.repositories.borrow.BorrowsRepository;
import io.github.maciejbiela.designpatternsproject.core.repositories.borrowers.BorrowersRepository;
import io.github.maciejbiela.designpatternsproject.core.repositories.items.ItemsRepository;
import io.github.maciejbiela.designpatternsproject.dataproviders.simplejava.repositories.SimpleBorrowersRepository;
import io.github.maciejbiela.designpatternsproject.dataproviders.simplejava.repositories.SimpleBorrowsRepository;
import io.github.maciejbiela.designpatternsproject.dataproviders.simplejava.repositories.SimpleItemsRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelConfiguration extends SimpleModule {
    @Override
    public void setupModule(SetupContext context) {
        context.setMixInAnnotations(Borrow.class, BorrowMixIn.class);
        context.setMixInAnnotations(Borrower.class, BorrowerMixIn.class);
        context.setMixInAnnotations(Item.class, ItemMixIn.class);
    }

    @JsonDeserialize(as = BorrowImpl.class)
    private class BorrowMixIn {
    }

    @Bean
    public BorrowsRepository borrowsRepository() {
        return new SimpleBorrowsRepository();
    }

    @JsonDeserialize(as = BorrowerImpl.class)
    private class BorrowerMixIn {
    }

    @Bean
    public BorrowersRepository borrowersRepository() {
        return new SimpleBorrowersRepository();
    }

    @JsonDeserialize(as = ItemImpl.class)
    private class ItemMixIn {
    }

    @Bean
    public ItemsRepository itemsRepository() {
        return new SimpleItemsRepository();
    }
}
