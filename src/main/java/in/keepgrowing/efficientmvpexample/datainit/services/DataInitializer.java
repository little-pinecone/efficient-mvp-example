package in.keepgrowing.efficientmvpexample.datainit.services;

import in.keepgrowing.efficientmvpexample.book.init.BookInitializer;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class DataInitializer {

    private final BookInitializer bookInitializer;

    public DataInitializer(BookInitializer bookInitializer) {
        this.bookInitializer = bookInitializer;
    }

    public Long init(Long seed) {
        var dummy = new CustomDummy(seed, null, null);

        bookInitializer.resetTable();
        bookInitializer.init(dummy, 20);

        return dummy.getSeed();
    }
}
