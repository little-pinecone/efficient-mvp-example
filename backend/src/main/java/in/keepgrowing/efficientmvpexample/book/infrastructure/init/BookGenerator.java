package in.keepgrowing.efficientmvpexample.book.infrastructure.init;

import in.keepgrowing.efficientmvpexample.book.domain.model.Book;
import in.keepgrowing.efficientmvpexample.datainit.services.CustomDummy;

public class BookGenerator {

    public Book generate(CustomDummy dummy) {
        return new Book(null, dummy.book().title());
    }
}
