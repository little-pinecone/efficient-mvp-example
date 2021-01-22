package in.keepgrowing.efficientmvpexample.book.repositories;

import in.keepgrowing.efficientmvpexample.book.model.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookSpringRepository extends CrudRepository<Book, Long> {
}
