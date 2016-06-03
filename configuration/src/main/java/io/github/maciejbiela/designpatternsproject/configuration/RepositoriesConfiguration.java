package io.github.maciejbiela.designpatternsproject.configuration;

import io.github.maciejbiela.designpatternsproject.core.repositories.borrow.BorrowsRepository;
import io.github.maciejbiela.designpatternsproject.core.repositories.borrowers.BorrowersRepository;
import io.github.maciejbiela.designpatternsproject.core.repositories.items.ItemsRepository;
import io.github.maciejbiela.designpatternsproject.dataproviders.jpa.JpaItemsRepository;
import io.github.maciejbiela.designpatternsproject.dataproviders.simplejava.SimpleBorrowersRepository;
import io.github.maciejbiela.designpatternsproject.dataproviders.simplejava.SimpleBorrowsRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RepositoriesConfiguration {
    @Bean
    public BorrowersRepository borrowersRepository() {
        return new SimpleBorrowersRepository();
    }

    @Bean
    public BorrowsRepository borrowsRepository() {
        return new SimpleBorrowsRepository();
    }

    @Bean
    public ItemsRepository itemsRepository() {
        return new JpaItemsRepository();
    }
}
