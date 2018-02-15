package tzc.library.persistence.jpa;

import java.util.UUID;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;

import tzc.library.Author;
import tzc.library.Book;

/**
 * Implements the {@link Book} model for JPA.
 *
 * @author Lucian Tuca
 * created on 01/02/2018
 */
@Entity(name = "book")
public class BookEntity implements Book {

    @Id
    private String id;

    @Embedded
    private AuthorEmbeddable author;

    private String content;

    public BookEntity() {
        this.id = UUID.randomUUID().toString();
    }

    public BookEntity(Book book) {
        this.id = book.getId();
        this.author = new AuthorEmbeddable(book.getAuthor());
        this.content = book.getContent();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = new AuthorEmbeddable(author);
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
