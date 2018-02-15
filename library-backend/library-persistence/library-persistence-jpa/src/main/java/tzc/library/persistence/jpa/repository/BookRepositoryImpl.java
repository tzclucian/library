package tzc.library.persistence.jpa.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import tzc.library.Book;
import tzc.library.persistence.api.BookRepository;
import tzc.library.persistence.jpa.BookEntity;

/**
 * {@link Book} repository implementation using the JPA Spring generated bean {@link BookJpaRepository}
 *
 * @author Lucian Tuca
 * created on 02/02/2018
 */
@Repository
public class BookRepositoryImpl implements BookRepository {

    @Autowired
    private BookJpaRepository bookJpaRepository;

    @Override
    public Book createBook(Book book) {
        return bookJpaRepository.save(new BookEntity(book));
    }

    @Override
    public Book readBook(String id) {
        return bookJpaRepository.findOne(id);
    }

    @Override
    public Book updateBook(String idOfBookToBeUpdated, Book newBook) {
        return bookJpaRepository.save(new BookEntity(newBook));
    }

    @Override
    public void deleteBook(String idOfBookToBeDeleted) {
        Book book = bookJpaRepository.findOne(idOfBookToBeDeleted);
        bookJpaRepository.delete(new BookEntity(book));
    }

    @Override
    public List<Book> findAllBooksByAuthorName(String authorName) {
        List<BookEntity> bookEntities = bookJpaRepository.findAllByAuthor_Name(authorName);
        return new ArrayList<>(bookEntities);
    }
}
