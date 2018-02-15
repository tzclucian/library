package tzc.library.persistence.couchbase.repository;

import java.util.List;

import org.springframework.data.couchbase.core.query.View;
import org.springframework.data.repository.CrudRepository;

import tzc.library.persistence.couchbase.BookDocument;

/**
 * Couchbase repository for the {@link BookDocument} provided by Spring.
 *
 * @author Lucian Tuca
 * @date 09/02/2018
 */
public interface BookCouchbaseRepository extends CrudRepository<BookDocument, String> {

    @View(designDocument = "bookDocument", viewName = "byName")
    List<BookDocument> findBooksByAuthorName(String name);
}
