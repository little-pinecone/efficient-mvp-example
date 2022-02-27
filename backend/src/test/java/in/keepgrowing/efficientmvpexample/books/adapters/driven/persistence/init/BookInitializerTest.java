package in.keepgrowing.efficientmvpexample.books.adapters.driven.persistence.init;

import in.keepgrowing.efficientmvpexample.books.domain.model.Book;
import in.keepgrowing.efficientmvpexample.books.domain.persistence.BookRepository;
import in.keepgrowing.efficientmvpexample.datainit.adapters.driven.services.CustomDummy;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class BookInitializerTest {

    private final CustomDummy dummy = new CustomDummy(123L, null, null);

    private BookInitializer bookInitializer;

    @Mock
    private BookGenerator bookGenerator;

    @Mock
    private BookRepository bookRepository;

    @BeforeEach
    void setUp() {
        bookInitializer = new BookInitializer(bookGenerator, bookRepository);
    }

    @Test
    void shouldResetTable() {
        bookInitializer.resetTable();

        verify(bookRepository, times(1)).resetTable();
    }

    @Test
    void shouldInitializeBooks() {
        var book = mock(Book.class);
        when(bookGenerator.generate(dummy))
                .thenReturn(book);

        bookInitializer.init(dummy, 1);

        verify(bookRepository, times(1)).saveAll(List.of(book));
    }
}