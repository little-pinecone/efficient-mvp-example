package in.keepgrowing.efficientmvpexample.book.presentation.viewmodel;

import in.keepgrowing.efficientmvpexample.book.model.Book;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;

import static org.junit.jupiter.api.Assertions.*;

class BookDtoConverterTest {

    private static final ModelMapper modelMapper = new ModelMapper();

    private BookDtoConverter converter;

    @BeforeEach
    void setUp() {
        converter = new BookDtoConverter(modelMapper);
    }

    @Test
    void shouldConvertToDto() {
        var book = new Book();
        var actual = converter.toDto(book);

        assertAll(
                () -> assertNotNull(actual, "Null instead of an object"),
                () -> assertNull(actual.getTitle(), "Title should be null")
        );
    }
}