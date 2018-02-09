package tzc.library.persistence.couchbase;

import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.couchbase.config.AbstractCouchbaseConfiguration;
import org.springframework.data.couchbase.repository.config.EnableCouchbaseRepositories;

import com.couchbase.client.java.env.CouchbaseEnvironment;
import com.couchbase.client.java.env.DefaultCouchbaseEnvironment;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import tzc.library.Author;
import tzc.library.Book;

/**
 * Configuration class for the all the Couchbase settings.
 *
 * @author Lucian Tuca
 * @date 09/02/2018
 */
@Configuration
@ComponentScan
@EnableCouchbaseRepositories
public class LibraryCouchbaseConfig extends AbstractCouchbaseConfiguration implements InitializingBean{
    private static final Logger LOGGER = LoggerFactory.getLogger(LibraryCouchbaseConfig.class);

    @Autowired(required = false)
    private ObjectMapper objectMapper;

    @Override
    public void afterPropertiesSet() throws Exception {
        if (objectMapper != null) {

            LOGGER.info("Adding custom object mapper modules.");

            // Only add the modules if an existing object mapper could be wired in.
            final SimpleModule bookModule = new SimpleModule();
            bookModule.addAbstractTypeMapping(Book.class, BookDocument.class);

            final SimpleModule authorModule = new SimpleModule();
            authorModule.addAbstractTypeMapping(Author.class, AuthorImpl.class);

            // Register the modules
            objectMapper.registerModules(bookModule, authorModule);
        }
    }

    @Value("${couchbase.host:localhost}")
    private String couchbaseHost;

    @Value("${couchbase.bucket:default}")
    private String bucket;

    @Value("${couchbase.bucketPassword}")
    private String bucketPassword;

    @Value("${couchbase.connectTimeout:15000}")
    private long timeout;

    @Override
    protected CouchbaseEnvironment getEnvironment() {
        DefaultCouchbaseEnvironment.builder().connectTimeout(timeout);
        return super.getEnvironment();
    }


    @Override
    protected List<String> getBootstrapHosts() {
        return Arrays.asList(couchbaseHost);
    }

    @Override
    protected String getBucketName() {
        return bucket;
    }

    @Override
    protected String getBucketPassword() {
        return bucketPassword;
    }
}
