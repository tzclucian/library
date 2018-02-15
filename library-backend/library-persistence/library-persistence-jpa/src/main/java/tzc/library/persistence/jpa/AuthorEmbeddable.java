package tzc.library.persistence.jpa;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import tzc.library.Author;

/**
 * Implements the {@link Author} model for JPA.
 *
 * @author Lucian Tuca
 * created on 02/02/2018
 */
@Embeddable
public class AuthorEmbeddable implements Author {

    @Column(name = "name")
    private String name;

    public AuthorEmbeddable() {}

    public AuthorEmbeddable(Author author) {
        this.name = author.getName();
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }
}
