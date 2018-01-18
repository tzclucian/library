package tzc.altpachet;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import tzc.library.Author;
import tzc.library.Book;
import tzc.library.ConnectionThatListens;

/**
 * @author Lucian Tuca
 * @date 18/01/2018
 */
@Configuration
@ComponentScan(basePackages = {"tzc.library", "tzc.fruits"})
@PropertySource("classpath:application.properties")
public class LibraryConfig {

    @Bean
    public Book book(Author author) {
        Book book = new Book();
        book.setAuthor(author);

        return book;
    }

    @Bean
    public ConnectionThatListens connectionThatListens(
            @Value("${ip:a.b.c.c}") String ip) {
        System.out.println(ip);
        ConnectionThatListens connectionThatListens =
                new ConnectionThatListens();
        connectionThatListens.setServerIp(ip);
        return connectionThatListens;
    }

}
