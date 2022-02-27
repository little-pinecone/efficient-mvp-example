package in.keepgrowing.efficientmvpexample.books.config;

import in.keepgrowing.efficientmvpexample.books.domain.persistence.BookRepository;
import in.keepgrowing.efficientmvpexample.books.adapters.driven.persistence.init.BookGenerator;
import in.keepgrowing.efficientmvpexample.books.adapters.driven.persistence.repositories.BookJpaRepository;
import in.keepgrowing.efficientmvpexample.books.adapters.driven.persistence.repositories.BookSpringRepository;
import in.keepgrowing.efficientmvpexample.books.adapters.driving.api.http.model.responses.BookDtoMapper;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BookBeanConfig {

    private final ModelMapper modelMapper;

    public BookBeanConfig(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Bean
    public BookRepository bookRepository(BookSpringRepository bookSpringRepository) {
        return new BookJpaRepository(bookSpringRepository);
    }

    @Bean
    public BookDtoMapper bookDtoMapper() {
        return new BookDtoMapper(modelMapper);
    }

    @Bean
    public BookGenerator bookGenerator() {
        return new BookGenerator();
    }
}
