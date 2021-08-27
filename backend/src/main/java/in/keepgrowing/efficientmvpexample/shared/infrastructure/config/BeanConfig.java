package in.keepgrowing.efficientmvpexample.shared.infrastructure.config;

import in.keepgrowing.efficientmvpexample.book.infrastructure.init.BookGenerator;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig {

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

    @Bean
    public BookGenerator bookGenerator() {
        return new BookGenerator();
    }
}
