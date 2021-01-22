package in.keepgrowing.efficientmvpexample.book.presentation.controllers;

import in.keepgrowing.efficientmvpexample.book.presentation.viewmodel.BookDto;
import in.keepgrowing.efficientmvpexample.book.presentation.viewmodel.BookDtoConverter;
import in.keepgrowing.efficientmvpexample.book.repositories.BookRepository;
import in.keepgrowing.efficientmvpexample.shared.presentation.controllers.ApiControllerPaths;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
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
@Tag(name = "Books")
public class BookController {

    private final BookRepository bookRepository;
    private final BookDtoConverter bookDtoConverter;

    public BookController(BookRepository bookRepository, BookDtoConverter bookDtoConverter) {
        this.bookRepository = bookRepository;
        this.bookDtoConverter = bookDtoConverter;
    }

    @GetMapping("{bookId}")
    @Operation(summary = "Find book by id")
    public ResponseEntity<BookDto> findById(@PathVariable Long bookId) {
        return bookRepository.findById(bookId)
                .map(bookDtoConverter::toDto)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }
}
