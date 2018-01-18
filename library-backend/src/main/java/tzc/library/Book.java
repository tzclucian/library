package tzc.library;

import org.springframework.context.ApplicationContext;

/**
 * @author Lucian Tuca
 * @date 16/01/2018
 */
public class Book {
    private Author author;

    private ApplicationContext applicationContext;

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }
}
