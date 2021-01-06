package in.keepgrowing.efficientmvpexample.book.config;

import in.keepgrowing.efficientmvpexample.book.repositories.BookRepository;
import in.keepgrowing.efficientmvpexample.book.presentation.viewmodel.BookDtoConverter;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BookConfig {

    private final ModelMapper modelMapper;

    public BookConfig(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Bean
    public BookRepository bookService() {
        return new BookRepository();
    }

    @Bean
    public BookDtoConverter bookDtoConverter() {
        return new BookDtoConverter(modelMapper);
    }
}
