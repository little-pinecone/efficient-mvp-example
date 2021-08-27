package in.keepgrowing.efficientmvpexample.book.infrastructure.config;

import in.keepgrowing.efficientmvpexample.book.presentation.viewmodel.BookDtoMapper;
import in.keepgrowing.efficientmvpexample.book.infrastructure.repositories.BookJpaRepository;
import in.keepgrowing.efficientmvpexample.book.domain.repositories.BookRepository;
import in.keepgrowing.efficientmvpexample.book.infrastructure.repositories.BookSpringRepository;
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
}
