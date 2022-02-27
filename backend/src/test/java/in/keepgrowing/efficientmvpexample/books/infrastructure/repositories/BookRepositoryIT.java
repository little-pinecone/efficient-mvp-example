package in.keepgrowing.efficientmvpexample.books.infrastructure.repositories;

import in.keepgrowing.efficientmvpexample.books.domain.persistence.BookRepository;
import in.keepgrowing.efficientmvpexample.books.adapters.driven.persistence.init.BookGenerator;
import in.keepgrowing.efficientmvpexample.containers.PostgresContainerWrapper;
import in.keepgrowing.efficientmvpexample.datainit.infrastructure.services.CustomDummy;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@Testcontainers
@SpringBootTest
class BookRepositoryIT {

    @Container
    public static PostgresContainerWrapper postgres = PostgresContainerWrapper.getContainer();

    private final CustomDummy customDummy = new CustomDummy(123L, null, null);

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private BookGenerator bookGenerator;

    @DynamicPropertySource
    static void postgreSQLProperties(DynamicPropertyRegistry registry) {
        postgres.setPostgreSQLProperties(registry);
    }

    @AfterEach
    void tearDown() {
        bookRepository.resetTable();
    }

    @Test
    void shouldFindById() {
        var book = bookGenerator.generate(customDummy);
        bookRepository.save(book);

        var actual = bookRepository.findById(1L);

        assertNotNull(actual);
        assertTrue(actual.isPresent(), "Empty optional");
    }

    @Test
    void shouldFindAll() {
        var book = bookGenerator.generate(customDummy);
        bookRepository.save(book);

        var actual = bookRepository.findAll();

        assertEquals(1, actual.size());
    }

    @Test
    void shouldSaveOneBook() {
        var book = bookGenerator.generate(customDummy);
        bookRepository.save(book);

        var actual = bookRepository.findById(1L);

        assertNotNull(actual);
        assertTrue(actual.isPresent(), "Empty optional");

        var value = actual.get();
        assertNotNull(value.getTitle(), "Null title");
        assertFalse(value.getTitle().isBlank(), "Blank title");
    }

    @Test
    void shouldSaveAll() {
        var books = List.of(bookGenerator.generate(customDummy));
        bookRepository.saveAll(books);

        var actual = bookRepository.findAll();

        assertEquals(1, actual.size());
    }

    @Test
    void shouldDeleteOneBook() {
        var book = bookGenerator.generate(customDummy);
        var saved = bookRepository.save(book);

        bookRepository.delete(saved);

        assertTrue(bookRepository.findAll().isEmpty());
    }

    @Test
    void shouldDeleteAll() {
        var book = bookGenerator.generate(customDummy);
        bookRepository.save(book);

        bookRepository.deleteAll();

        assertTrue(bookRepository.findAll().isEmpty());
    }

    @Test
    void shouldResetTable() {
        bookRepository.save(bookGenerator.generate(customDummy));

        bookRepository.resetTable();
        bookRepository.save(bookGenerator.generate(customDummy));

        assertAll(
                () -> assertEquals(1, bookRepository.findAll().size(), "Invalid list size"),
                () -> assertTrue(bookRepository.findById(1L).isPresent(), "Empty optional")
        );
    }
}