package in.keepgrowing.efficientmvpexample.book.repositories;

import in.keepgrowing.efficientmvpexample.book.model.Book;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Optional;

@Slf4j
public class BookRepository {

    private final BookSpringRepository bookSpringRepository;

    public BookRepository(BookSpringRepository bookSpringRepository) {
        this.bookSpringRepository = bookSpringRepository;
    }

    public Optional<Book> findById(Long bookId) {
        return bookSpringRepository.findById(bookId);
    }

    public List<Book> findAll() {
        return bookSpringRepository.findAll();
    }

    public Book save(Book book) {
        return bookSpringRepository.save(book);
    }

    public void saveAll(List<Book> books) {
        bookSpringRepository.saveAll(books);
    }

    public void delete(Book book) {
        log.debug("Removing book: {}", book.getId());
        bookSpringRepository.delete(book);
    }

    public void deleteAll() {
        log.debug("Removing all records from book table");
        bookSpringRepository.deleteAll();
    }

    public void resetTable() {
        deleteAll();

        log.debug("Restarting database sequence for book_id");
        bookSpringRepository.restartDatabaseSequence();
    }
}
