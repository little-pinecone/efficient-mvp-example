package in.keepgrowing.efficientmvpexample.book.presentation.viewmodel;

import in.keepgrowing.efficientmvpexample.book.model.Book;
import org.modelmapper.ModelMapper;

public class BookDtoConverter {

    private final ModelMapper modelMapper;

    public BookDtoConverter(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public BookDto toDto(Book book) {
        return modelMapper.map(book, BookDto.class);
    }
}
