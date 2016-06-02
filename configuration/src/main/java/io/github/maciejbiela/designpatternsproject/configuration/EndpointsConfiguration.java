package io.github.maciejbiela.designpatternsproject.configuration;

import io.github.maciejbiela.designpatternsproject.core.usecases.borrow.BorrowUseCases;
import io.github.maciejbiela.designpatternsproject.entrypoints.rest.BorrowsEndpoint;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EndpointsConfiguration {
    @Bean
    public BorrowsEndpoint borrowsEndpoint(BorrowUseCases borrowUseCases) {
        return new BorrowsEndpoint(borrowUseCases);
    }
}
