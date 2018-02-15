package tzc.library.persistence.couchbase;

import java.util.UUID;

import org.springframework.data.annotation.Id;
import org.springframework.data.couchbase.core.mapping.Document;

import com.couchbase.client.java.repository.annotation.Field;
import tzc.library.Author;
import tzc.library.Book;

/**
 * Couchbase specific model.
 *
 * @author Lucian Tuca
 * created on 09/02/2018
 */
@Document
public class BookDocument implements Book {

    @Id
    private String id;

    @Field
    private String content;

    @Field
    private AuthorImpl author;

    public BookDocument() {
        this.id = UUID.randomUUID().toString();
    }

    public BookDocument(Book book) {
        this.id = book.getId();
        this.content = book.getContent();
        this.author = new AuthorImpl(book.getAuthor());
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String getContent() {
        return content;
    }

    @Override
    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public AuthorImpl getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = new AuthorImpl(author);
    }
}
