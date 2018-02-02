package tzc.library;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import tzc.library.service.BookService;

/**
 * The Book controller.
 *
 * @author Lucian Tuca
 * @date 25/01/2018
 */
@RestController
@RequestMapping("/book")
public class BookController {

    private static final Logger LOGGER = LoggerFactory.getLogger(BookController.class);

    @Autowired
    private BookService bookService;

    @RequestMapping(value = "", method = RequestMethod.POST)
    public ResponseEntity<Book> createBook(@RequestBody Book book) {
        LOGGER.info("Creating book: ", book);

        bookService.createBook(book);

        return new ResponseEntity<Book>(book, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Book> readBook(@PathVariable String id) {
        LOGGER.info("Retrieving book with id: " + id);

        Book book = bookService.readBook(id);

        return new ResponseEntity<Book>(book, HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Book> updateBook(@RequestBody Book newBook, @PathVariable String id) {
        LOGGER.info("Updating book with id: " + id + " with book ", newBook);

        Book book = bookService.updateBook(id, newBook);

        return new ResponseEntity<Book>(book, HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteBook(@PathVariable String id) {
        LOGGER.info("Deleting book with id: " + id);

        bookService.deleteBook(id);

        return new ResponseEntity<Book>(HttpStatus.NO_CONTENT);
    }
}
