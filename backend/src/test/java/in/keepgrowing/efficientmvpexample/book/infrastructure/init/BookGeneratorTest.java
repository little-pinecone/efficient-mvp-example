package in.keepgrowing.efficientmvpexample.book.infrastructure.init;

import in.keepgrowing.efficientmvpexample.datainit.services.CustomDummy;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class BookGeneratorTest {

    private BookGenerator bookGenerator;

    private final CustomDummy dummy = new CustomDummy(123L, null, null);

    @BeforeEach
    void setUp() {
        bookGenerator = new BookGenerator();
    }

    @Test
    void shouldGenerateBook() {
        var actual = bookGenerator.generate(dummy);

        assertNotNull(actual);
        assertNull(actual.getId(), "Non null id");
        assertNotNull(actual.getTitle(), "Null title");
        assertFalse(actual.getTitle().isBlank(), "Blank title");
    }
}