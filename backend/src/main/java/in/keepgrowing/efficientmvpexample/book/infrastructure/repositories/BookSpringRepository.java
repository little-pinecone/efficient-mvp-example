package in.keepgrowing.efficientmvpexample.book.infrastructure.repositories;

import in.keepgrowing.efficientmvpexample.book.domain.model.Book;
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
