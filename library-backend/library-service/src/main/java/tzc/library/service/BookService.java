package tzc.library.service;

import java.util.List;

import tzc.library.Book;

/**
 * Defines how a {@link BookService} should behave.
 *
 * @author Lucian Tuca
 * created on 01/02/2018
 */
public interface BookService {
    Book createBook(Book book);

    Book readBook(String id);

    Book updateBook(String idOfBookToBeUpdated, Book newBook);

    void deleteBook(String idOfBookToBeDeleted);

    List<Book> findAllBooksByAuthorName(String authorName);
}
