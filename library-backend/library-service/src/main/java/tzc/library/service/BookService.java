package tzc.library.service;

import tzc.library.Book;

/**
 * Defines how a {@link BookService} should behave.
 *
 * @author Lucian Tuca
 * @date 01/02/2018
 */
public interface BookService {
    Book createBook(Book book);

    Book readBook(String id);

    Book updateBook(String idOfBookToBeUpdated, Book newBook);

    void deleteBook(String idOfBookToBeDeleted);
}
