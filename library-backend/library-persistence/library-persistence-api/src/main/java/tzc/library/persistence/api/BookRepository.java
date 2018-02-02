package tzc.library.persistence.api;


import tzc.library.Book;

/**
 * Defines how a {@link Book} repository should behave.
 *
 * @author Lucian Tuca
 * @date 01/02/2018
 */
public interface BookRepository {
    Book createBook(Book book);

    Book readBook(String id);

    Book updateBook(String idOfBookToBeUpdated, Book newBook);

    void deleteBook(String idOfBookToBeDeleted);
}
