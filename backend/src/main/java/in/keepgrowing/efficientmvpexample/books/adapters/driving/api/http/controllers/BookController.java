package in.keepgrowing.efficientmvpexample.books.adapters.driving.api.http.controllers;

import in.keepgrowing.efficientmvpexample.books.adapters.driving.api.http.model.responses.BookResponse;
import in.keepgrowing.efficientmvpexample.books.adapters.driving.api.http.model.responses.BookDtoMapper;
import in.keepgrowing.efficientmvpexample.books.domain.persistence.BookRepository;
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
    private final BookDtoMapper bookDtoMapper;

    public BookController(BookRepository bookRepository, BookDtoMapper bookDtoMapper) {
        this.bookRepository = bookRepository;
        this.bookDtoMapper = bookDtoMapper;
    }

    @GetMapping("{bookId}")
    @Operation(summary = "Find book by id")
    public ResponseEntity<BookResponse> findById(@PathVariable Long bookId) {
        return bookRepository.findById(bookId)
                .map(bookDtoMapper::toDto)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }
}
