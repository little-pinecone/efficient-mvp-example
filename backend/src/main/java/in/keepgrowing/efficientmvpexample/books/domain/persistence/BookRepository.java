package in.keepgrowing.efficientmvpexample.books.domain.persistence;

import in.keepgrowing.efficientmvpexample.books.domain.model.Book;

import java.util.List;
import java.util.Optional;

public interface BookRepository {

    Optional<Book> findById(Long bookId);

    List<Book> findAll();

    Book save(Book book);

    void saveAll(List<Book> books);

    void delete(Book book);

    void deleteAll();

    void resetTable();
}
