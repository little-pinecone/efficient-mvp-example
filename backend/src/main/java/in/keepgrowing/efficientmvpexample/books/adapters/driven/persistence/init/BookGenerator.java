package in.keepgrowing.efficientmvpexample.books.adapters.driven.persistence.init;

import in.keepgrowing.efficientmvpexample.books.domain.model.Book;
import in.keepgrowing.efficientmvpexample.datainit.infrastructure.services.CustomDummy;

public class BookGenerator {

    public Book generate(CustomDummy dummy) {
        return new Book(null, dummy.book().title());
    }
}
