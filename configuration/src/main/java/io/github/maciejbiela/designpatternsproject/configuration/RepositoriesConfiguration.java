package io.github.maciejbiela.designpatternsproject.configuration;

import io.github.maciejbiela.designpatternsproject.core.repositories.borrow.BorrowsRepository;
import io.github.maciejbiela.designpatternsproject.core.repositories.borrowers.BorrowersRepository;
import io.github.maciejbiela.designpatternsproject.core.repositories.items.ItemsRepository;
import io.github.maciejbiela.designpatternsproject.dataproviders.jpa.repositories.JpaBorrowersRepository;
import io.github.maciejbiela.designpatternsproject.dataproviders.jpa.repositories.JpaBorrowsRepository;
import io.github.maciejbiela.designpatternsproject.dataproviders.jpa.repositories.JpaItemsRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RepositoriesConfiguration {
    @Bean
    public BorrowersRepository borrowersRepository() {
        return new JpaBorrowersRepository();
    }

    @Bean
    public BorrowsRepository borrowsRepository() {
        return new JpaBorrowsRepository();
    }

    @Bean
    public ItemsRepository itemsRepository() {
        return new JpaItemsRepository();
    }
}
