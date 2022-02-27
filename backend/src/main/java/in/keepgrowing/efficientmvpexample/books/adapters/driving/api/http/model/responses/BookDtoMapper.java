package in.keepgrowing.efficientmvpexample.books.adapters.driving.api.http.model.responses;

import in.keepgrowing.efficientmvpexample.books.domain.model.Book;
import org.modelmapper.ModelMapper;

public class BookDtoMapper {

    private final ModelMapper modelMapper;

    public BookDtoMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public BookResponse toDto(Book book) {
        return modelMapper.map(book, BookResponse.class);
    }
}
