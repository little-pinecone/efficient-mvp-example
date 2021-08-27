package in.keepgrowing.efficientmvpexample.datainit.config;

import in.keepgrowing.efficientmvpexample.book.infrastructure.init.BookGenerator;
import in.keepgrowing.efficientmvpexample.book.infrastructure.init.BookInitializer;
import in.keepgrowing.efficientmvpexample.book.domain.repositories.BookRepository;
import in.keepgrowing.efficientmvpexample.datainit.services.DataInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("init")
public class DataInitConfig {

    @Bean
    public DataInitializer dataInitializer(BookInitializer bookInitializer) {
        return new DataInitializer(bookInitializer);
    }

    @Bean
    public BookInitializer bookInitializer(BookGenerator bookGenerator, BookRepository bookRepository) {
        return new BookInitializer(bookGenerator, bookRepository);
    }
}
