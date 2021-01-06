package in.keepgrowing.efficientmvpexample.book.presentation.controllers;

import in.keepgrowing.efficientmvpexample.shared.presentation.controllers.ApiControllerPaths;
import in.keepgrowing.efficientmvpexample.book.repositories.BookRepository;
import in.keepgrowing.efficientmvpexample.book.presentation.viewmodel.BookDtoConverter;
import in.keepgrowing.efficientmvpexample.book.presentation.viewmodel.BookDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = ApiControllerPaths.API + BookControllerPaths.BOOKS,
        produces = MediaType.APPLICATION_JSON_VALUE)
public class BookController {

    private final BookRepository bookRepository;
    private final BookDtoConverter bookDtoConverter;

    public BookController(BookRepository bookRepository, BookDtoConverter bookDtoConverter) {
        this.bookRepository = bookRepository;
        this.bookDtoConverter = bookDtoConverter;
    }

    @GetMapping("{bookId}")
    public ResponseEntity<BookDto> findById(@PathVariable Long bookId) {
        return bookRepository.findById(bookId)
                .map(bookDtoConverter::toDto)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }
}
