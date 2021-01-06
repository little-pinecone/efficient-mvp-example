package in.keepgrowing.efficientmvpexample.book.repositories;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class BookRepositoryTest {

    private BookRepository bookRepository;

    @BeforeEach
    void setUp() {
        bookRepository = new BookRepository();
    }

    @Test
    void shouldReturnBook() {
        var actual = bookRepository.findById(1L);

        assertTrue(actual.isPresent());
    }
}