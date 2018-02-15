package tzc.library.persistence.couchbase;

import tzc.library.Author;

/**
 * Simple implementation for {@link Author}
 * @author Lucian Tuca
 * created on 09/02/2018
 */
public class AuthorImpl implements tzc.library.Author {
    private String name;

    public AuthorImpl() {
    }

    public AuthorImpl(Author author) {
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
