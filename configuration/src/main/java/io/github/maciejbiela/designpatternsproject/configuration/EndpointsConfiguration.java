package io.github.maciejbiela.designpatternsproject.configuration;

import io.github.maciejbiela.designpatternsproject.core.usecases.UseCases;
import io.github.maciejbiela.designpatternsproject.entrypoints.rest.BorrowsEndpoint;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EndpointsConfiguration {
    @Bean
    public BorrowsEndpoint borrowsEndpoint(UseCases useCases) {
        return new BorrowsEndpoint(useCases.getAllBorrowsUseCase());
    }
}
