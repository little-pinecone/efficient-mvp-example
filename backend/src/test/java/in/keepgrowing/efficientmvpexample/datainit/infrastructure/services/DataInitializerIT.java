package in.keepgrowing.efficientmvpexample.datainit.infrastructure.services;

import in.keepgrowing.efficientmvpexample.books.domain.persistence.BookRepository;
import in.keepgrowing.efficientmvpexample.containers.PostgresContainerWrapper;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@Testcontainers
@SpringBootTest
@ActiveProfiles("init")
class DataInitializerIT {

    @Container
    public static PostgresContainerWrapper postgres = PostgresContainerWrapper.getContainer();

    @Autowired
    private DataInitializer dataInitializer;

    @Autowired
    private BookRepository bookRepository;

    @DynamicPropertySource
    static void postgreSQLProperties(DynamicPropertyRegistry registry) {
        postgres.setPostgreSQLProperties(registry);
    }

    @AfterEach
    void tearDown() {
        bookRepository.resetTable();
    }

    @Test
    void shouldInitData() {
        dataInitializer.init(1L, 1);

        assertEquals(1, bookRepository.findAll().size());
    }

    @Test
    void shouldRestartDatabaseSequences() {
        dataInitializer.init(1L, 1);
        dataInitializer.init(1L, 1);

        assertTrue(bookRepository.findById(1L).isPresent());
    }
}