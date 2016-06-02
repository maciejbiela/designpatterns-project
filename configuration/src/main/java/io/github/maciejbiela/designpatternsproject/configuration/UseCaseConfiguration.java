package io.github.maciejbiela.designpatternsproject.configuration;

import io.github.maciejbiela.designpatternsproject.core.repositories.borrow.BorrowsRepository;
import io.github.maciejbiela.designpatternsproject.core.repositories.borrowers.BorrowersRepository;
import io.github.maciejbiela.designpatternsproject.core.repositories.items.ItemsRepository;
import io.github.maciejbiela.designpatternsproject.core.usecases.UseCases;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UseCaseConfiguration {
    @Bean
    public UseCases useCases(BorrowersRepository borrowersRepository, BorrowsRepository borrowsRepository, ItemsRepository itemsRepository) {
        return new UseCases(borrowersRepository, borrowsRepository, itemsRepository);
    }
}
