package in.keepgrowing.efficientmvpexample.book.presentation.viewmodel;

import in.keepgrowing.efficientmvpexample.book.domain.model.Book;
import org.modelmapper.ModelMapper;

public class BookDtoMapper {

    private final ModelMapper modelMapper;

    public BookDtoMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public BookDto toDto(Book book) {
        return modelMapper.map(book, BookDto.class);
    }
}
