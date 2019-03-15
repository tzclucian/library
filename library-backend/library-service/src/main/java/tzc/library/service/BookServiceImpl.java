package tzc.library.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tzc.library.Book;
import tzc.library.metrics.MeteringUtil;
import tzc.library.persistence.api.BookRepository;

/**
 * Implementation of the {@link BookService} using persistence, see {@link BookRepository}
 *
 * @author Lucian Tuca
 * created on 01/02/2018
 */
@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private MeteringUtil meteringUtil;

    @Override
    public Book createBook(Book book) {
        return bookRepository.createBook(book);
    }

    @Override
    public Book readBook(String id) {
        meteringUtil.registerCall();
        return bookRepository.readBook(id);
    }

    @Override
    public Book updateBook(String idOfBookToBeUpdated, Book newBook) {
        return bookRepository.updateBook(idOfBookToBeUpdated, newBook);
    }

    @Override
    public void deleteBook(String idOfBookToBeDeleted) {
        bookRepository.deleteBook(idOfBookToBeDeleted);
    }

    @Override
    public List<Book> findAllBooksByAuthorName(String authorName) {
        return bookRepository.findAllBooksByAuthorName(authorName);
    }
}
