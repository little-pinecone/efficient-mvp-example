package in.keepgrowing.efficientmvpexample.book.repositories;

import in.keepgrowing.efficientmvpexample.book.model.Book;

import java.util.Optional;

public class BookRepository {

    public Optional<Book> findById(Long bookId) {
        return Optional.of(new Book());
    }
}
