package tzc.library.persistence.jpa;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import tzc.library.Author;
import tzc.library.Book;

/**
 * Spring {@link Configuration} of the JPA persistence module.
 *
 * @author Lucian Tuca
 * @date 02/02/2018
 */
@Configuration
@ComponentScan
@EnableAutoConfiguration
public class LibraryJpaConfig implements InitializingBean {

    private static final Logger LOGGER = LoggerFactory.getLogger(LibraryJpaConfig.class);

    @Autowired(required = false)
    private ObjectMapper objectMapper;

    @Override
    public void afterPropertiesSet() throws Exception {
        if (objectMapper != null) {

            LOGGER.info("Adding custom object mapper modules.");

            // Only add the modules if an existing object mapper could be wired in.
            final SimpleModule bookModule = new SimpleModule();
            bookModule.addAbstractTypeMapping(Book.class, BookEntity.class);

            final SimpleModule authorModule = new SimpleModule();
            authorModule.addAbstractTypeMapping(Author.class, AuthorEmbeddable.class);

            // Register the modules
            objectMapper.registerModules(bookModule, authorModule);
        }
    }
}
