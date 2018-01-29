package tzc.library;

/**
 * @author Lucian Tuca
 * @date 25/01/2018
 */
public class Book {
    private String id;
    private String content;
    private String author;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "{"
                + "                        \"content\": " + (content != null ? "\"" + content + "\"" : null)
                + ",                         \"author\": " + (author != null ? "\"" + author + "\"" : null)
                + "}";
    }
}
