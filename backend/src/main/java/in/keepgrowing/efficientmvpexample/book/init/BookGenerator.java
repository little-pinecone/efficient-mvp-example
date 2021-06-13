package in.keepgrowing.efficientmvpexample.book.init;

import in.keepgrowing.efficientmvpexample.book.model.Book;
import in.keepgrowing.efficientmvpexample.datainit.services.CustomDummy;

public class BookGenerator {

    public Book generate(CustomDummy dummy) {
        return new Book(null, dummy.book().title());
    }
}
