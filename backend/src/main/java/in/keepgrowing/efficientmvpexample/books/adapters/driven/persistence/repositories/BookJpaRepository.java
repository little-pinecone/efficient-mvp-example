package in.keepgrowing.efficientmvpexample.books.adapters.driven.persistence.repositories;

import in.keepgrowing.efficientmvpexample.books.domain.model.Book;
import in.keepgrowing.efficientmvpexample.books.domain.persistence.BookRepository;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Optional;

@Slf4j
public class BookJpaRepository implements BookRepository {

    private final BookSpringRepository bookSpringRepository;

    public BookJpaRepository(BookSpringRepository bookSpringRepository) {
        this.bookSpringRepository = bookSpringRepository;
    }

    @Override
    public Optional<Book> findById(Long bookId) {
        return bookSpringRepository.findById(bookId);
    }

    @Override
    public List<Book> findAll() {
        return bookSpringRepository.findAll();
    }

    @Override
    public Book save(Book book) {
        return bookSpringRepository.save(book);
    }

    @Override
    public void saveAll(List<Book> books) {
        bookSpringRepository.saveAll(books);
    }

    @Override
    public void delete(Book book) {
        log.debug("Removing book: {}", book.getId());
        bookSpringRepository.delete(book);
    }

    @Override
    public void deleteAll() {
        log.debug("Removing all records from book table");
        bookSpringRepository.deleteAll();
    }

    @Override
    public void resetTable() {
        deleteAll();

        log.debug("Restarting database sequence for book_id");
        bookSpringRepository.restartDatabaseSequence();
    }
}
