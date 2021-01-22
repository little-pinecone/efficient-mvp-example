package in.keepgrowing.efficientmvpexample.book.repositories;

import in.keepgrowing.efficientmvpexample.book.model.Book;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class BookRepositoryTest {

    private BookRepository bookRepository;

    @Mock
    private BookSpringRepository bookSpringRepository;

    @BeforeEach
    void setUp() {
        bookRepository = new BookRepository(bookSpringRepository);
    }

    @Test
    void shouldReturnBook() {
        when(bookSpringRepository.findById(1L))
                .thenReturn(Optional.of(mock(Book.class)));

        var actual = bookRepository.findById(1L);

        assertTrue(actual.isPresent());
    }
}