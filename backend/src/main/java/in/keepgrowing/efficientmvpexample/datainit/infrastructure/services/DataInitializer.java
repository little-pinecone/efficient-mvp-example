package in.keepgrowing.efficientmvpexample.datainit.infrastructure.services;

import in.keepgrowing.efficientmvpexample.book.infrastructure.init.BookInitializer;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class DataInitializer {

    private final BookInitializer bookInitializer;

    public DataInitializer(BookInitializer bookInitializer) {
        this.bookInitializer = bookInitializer;
    }

    public Long init(Long seed, Integer howManyBooks) {
        var dummy = new CustomDummy(seed, null, null);

        bookInitializer.resetTable();
        bookInitializer.init(dummy, howManyBooks);

        return dummy.getSeed();
    }
}
