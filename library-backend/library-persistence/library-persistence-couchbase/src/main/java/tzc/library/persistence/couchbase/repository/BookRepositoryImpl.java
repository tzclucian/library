package tzc.library.persistence.couchbase.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import tzc.library.Book;
import tzc.library.persistence.api.BookRepository;
import tzc.library.persistence.couchbase.BookDocument;

/**
 * Implementation of the {@link BookRepository} using the the {@link BookCouchbaseRepository}
 *
 * @author Lucian Tuca
 * @date 09/02/2018
 */
@Repository
public class BookRepositoryImpl implements BookRepository {

    @Autowired
    private BookCouchbaseRepository bookCouchbaseRepository;

    @Override
    public Book createBook(Book book) {
        return bookCouchbaseRepository.save(new BookDocument(book));
    }

    @Override
    public Book readBook(String id) {
        return bookCouchbaseRepository.findOne(id);
    }

    @Override
    public Book updateBook(String idOfBookToBeUpdated, Book newBook) {
        return bookCouchbaseRepository.save(new BookDocument(newBook));
    }

    @Override
    public void deleteBook(String idOfBookToBeDeleted) {
        bookCouchbaseRepository.delete(idOfBookToBeDeleted);
    }
}
