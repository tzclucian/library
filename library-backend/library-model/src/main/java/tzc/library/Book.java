package tzc.library;

/**
 * Defines the Book model.
 *
 * @author Lucian Tuca
 * @date 01/02/2018
 */
public interface Book {
    public String getId();
    public void setId(String id);

    public String getContent();
    public void setContent(String content);

    public Author getAuthor();
    public void setAuthor(Author author);
}
