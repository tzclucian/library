package tzc.library;

/**
 * Defines the Book model.
 *
 * @author Lucian Tuca
 * created on 01/02/2018
 */
public interface Book {
    String getId();
    void setId(String id);

    String getContent();
    void setContent(String content);

    Author getAuthor();
    void setAuthor(Author author);
}
