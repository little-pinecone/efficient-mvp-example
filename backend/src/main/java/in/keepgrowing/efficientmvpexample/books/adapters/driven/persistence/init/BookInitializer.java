package in.keepgrowing.efficientmvpexample.books.adapters.driven.persistence.init;

import in.keepgrowing.efficientmvpexample.books.domain.persistence.BookRepository;
import in.keepgrowing.efficientmvpexample.datainit.infrastructure.services.CustomDummy;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class BookInitializer {

    private final BookGenerator bookGenerator;
    private final BookRepository bookRepository;

    public BookInitializer(BookGenerator bookGenerator, BookRepository bookRepository) {
        this.bookGenerator = bookGenerator;
        this.bookRepository = bookRepository;
    }

    public void resetTable() {
        bookRepository.resetTable();
    }

    public void init(CustomDummy dummy, int howMany) {
        log.debug("Generating random books");
        var books = dummy.listOf(howMany, () -> bookGenerator.generate(dummy));
        bookRepository.saveAll(books);
    }
}
