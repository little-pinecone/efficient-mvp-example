package in.keepgrowing.efficientmvpexample.book.repositories;

import in.keepgrowing.efficientmvpexample.book.model.Book;

import java.util.Optional;

public class BookRepository {

    private final BookSpringRepository bookSpringRepository;

    public BookRepository(BookSpringRepository bookSpringRepository) {
        this.bookSpringRepository = bookSpringRepository;
    }

    public Optional<Book> findById(Long bookId) {
        return bookSpringRepository.findById(bookId);
    }
}
