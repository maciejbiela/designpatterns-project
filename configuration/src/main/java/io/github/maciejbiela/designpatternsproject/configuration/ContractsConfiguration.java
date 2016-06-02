package io.github.maciejbiela.designpatternsproject.configuration;

import io.github.maciejbiela.designpatternsproject.core.usecases.borrow.BorrowUseCases;
import io.github.maciejbiela.designpatternsproject.core.usecases.borrower.BorrowerUseCases;
import io.github.maciejbiela.designpatternsproject.core.usecases.item.ItemUseCases;
import io.github.maciejbiela.designpatternsproject.entrypoints.contract.BorrowersContract;
import io.github.maciejbiela.designpatternsproject.entrypoints.contract.BorrowsContract;
import io.github.maciejbiela.designpatternsproject.entrypoints.contract.ItemsContract;
import io.github.maciejbiela.designpatternsproject.entrypoints.rest.BorrowersEndpoint;
import io.github.maciejbiela.designpatternsproject.entrypoints.rest.BorrowsEndpoint;
import io.github.maciejbiela.designpatternsproject.entrypoints.rest.ItemsEndpoint;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ContractsConfiguration {
    @Bean
    public BorrowsContract borrowsContract(BorrowUseCases borrowUseCases) {
        return new BorrowsEndpoint(borrowUseCases);
    }

    @Bean
    BorrowersContract borrowersContract(BorrowerUseCases borrowerUseCases) {
        return new BorrowersEndpoint(borrowerUseCases);
    }

    @Bean
    ItemsContract itemsContract(ItemUseCases itemUseCases) {
        return new ItemsEndpoint(itemUseCases);
    }
}
