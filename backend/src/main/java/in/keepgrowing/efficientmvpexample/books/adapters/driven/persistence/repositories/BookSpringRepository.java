package in.keepgrowing.efficientmvpexample.books.adapters.driven.persistence.repositories;

import in.keepgrowing.efficientmvpexample.books.domain.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface BookSpringRepository extends JpaRepository<Book, Long> {

    @Transactional
    @Modifying(clearAutomatically = true)
    @Query(nativeQuery = true, value = "ALTER SEQUENCE book_id_seq RESTART")
    void restartDatabaseSequence();
}
