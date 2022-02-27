package in.keepgrowing.efficientmvpexample.datainit.config;

import in.keepgrowing.efficientmvpexample.books.adapters.driven.persistence.init.BookGenerator;
import in.keepgrowing.efficientmvpexample.books.adapters.driven.persistence.init.BookInitializer;
import in.keepgrowing.efficientmvpexample.books.domain.persistence.BookRepository;
import in.keepgrowing.efficientmvpexample.datainit.adapters.driven.services.DataInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("init")
public class DataInitBeanConfig {

    @Bean
    public DataInitializer dataInitializer(BookInitializer bookInitializer) {
        return new DataInitializer(bookInitializer);
    }

    @Bean
    public BookInitializer bookInitializer(BookGenerator bookGenerator, BookRepository bookRepository) {
        return new BookInitializer(bookGenerator, bookRepository);
    }
}
