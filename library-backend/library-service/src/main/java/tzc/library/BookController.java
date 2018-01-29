package tzc.library;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Lucian Tuca
 * @date 25/01/2018
 */
@RestController
@RequestMapping("/book")
public class BookController {

    private static final Logger LOGGER = LoggerFactory.getLogger(BookController.class);

    @RequestMapping(value = "", method = RequestMethod.POST)
    public ResponseEntity<Book> createBook(@RequestBody Book book) {
        LOGGER.info("Creating book: ", book);

        // Call DB to persist Book

        return new ResponseEntity<Book>(book, HttpStatus.NOT_IMPLEMENTED);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Book> readBook(@PathVariable String id) {
        LOGGER.info("Retrieving book with id: " + id);

        // Call DB to retrieve the book

        return new ResponseEntity<Book>(HttpStatus.NOT_IMPLEMENTED);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Book> updateBook(@RequestBody Book newBook, @PathVariable Long id) {
        LOGGER.info("Updating book with id: " + id + " with book ", newBook);

        // Call DB to update the book

        return new ResponseEntity<Book>(HttpStatus.NOT_IMPLEMENTED);
    }

    @RequestMapping(value = "/{id}")
    public ResponseEntity<?> deleteBook(@PathVariable String id) {
        LOGGER.info("Deleting book with id: " + id);

        // Call DB to delete the book

        return new ResponseEntity<Book>(HttpStatus.NOT_IMPLEMENTED);
    }

    @RequestMapping(value = "/example/{id}")
    public ResponseEntity<?> completeExample(
            @PathVariable String id,
            @RequestParam String queryParam1,
            @RequestParam(required = false) String queryParam2,
            @RequestHeader(required = false) String myCustomHeader,
            @RequestBody Book book
    ) {

        // Notice the ResponseEntity<?>
        // This allows us to use any type for the ResponseBody
        // See the ResponseBody annotation

        LOGGER.info("Book id from request: " + id);
        LOGGER.info("Query parameter 1: " + queryParam1);
        LOGGER.info("Query parameter 2: " + queryParam2);
        LOGGER.info("Header parameter: " + myCustomHeader);
        LOGGER.info("Request body: " + book);

        if (id.length() % 2 == 1) {
            return new ResponseEntity<String>("{'error': 'We only accept IDs with even length.'}", HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<Book>(book, HttpStatus.OK);
    }
}
