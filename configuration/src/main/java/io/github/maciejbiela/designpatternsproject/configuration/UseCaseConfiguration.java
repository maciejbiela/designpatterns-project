package io.github.maciejbiela.designpatternsproject.configuration;

import io.github.maciejbiela.designpatternsproject.core.repositories.borrow.BorrowsRepository;
import io.github.maciejbiela.designpatternsproject.core.repositories.borrowers.BorrowersRepository;
import io.github.maciejbiela.designpatternsproject.core.repositories.items.ItemsRepository;
import io.github.maciejbiela.designpatternsproject.core.usecases.borrow.BorrowUseCases;
import io.github.maciejbiela.designpatternsproject.core.usecases.borrower.BorrowerUseCases;
import io.github.maciejbiela.designpatternsproject.core.usecases.item.ItemUseCases;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UseCaseConfiguration {
    @Bean
    public BorrowUseCases borrowUseCases(BorrowsRepository borrowsRepository, BorrowersRepository borrowersRepository, ItemsRepository itemsRepository) {
        return new BorrowUseCases(borrowsRepository, borrowersRepository, itemsRepository);
    }

    @Bean
    public BorrowerUseCases borrowerUseCases(BorrowsRepository borrowsRepository, BorrowersRepository borrowersRepository, ItemsRepository itemsRepository) {
        return new BorrowerUseCases(borrowsRepository, borrowersRepository, itemsRepository);
    }

    @Bean
    public ItemUseCases itemUseCases(ItemsRepository itemsRepository) {
        return new ItemUseCases(itemsRepository);
    }
}
