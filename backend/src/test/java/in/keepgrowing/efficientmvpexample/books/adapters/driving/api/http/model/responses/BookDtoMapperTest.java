package in.keepgrowing.efficientmvpexample.books.adapters.driving.api.http.model.responses;

import in.keepgrowing.efficientmvpexample.books.adapters.driving.api.http.model.responses.BookDtoMapper;
import in.keepgrowing.efficientmvpexample.books.domain.model.Book;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;

import static org.junit.jupiter.api.Assertions.*;

class BookDtoMapperTest {

    private static final ModelMapper modelMapper = new ModelMapper();

    private BookDtoMapper mapper;

    @BeforeEach
    void setUp() {
        mapper = new BookDtoMapper(modelMapper);
    }

    @Test
    void shouldConvertToDto() {
        var book = new Book();
        var actual = mapper.toDto(book);

        assertAll(
                () -> assertNotNull(actual, "Null instead of an object"),
                () -> assertNull(actual.getTitle(), "Title should be null")
        );
    }
}