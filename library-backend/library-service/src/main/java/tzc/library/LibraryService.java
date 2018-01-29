package tzc.library;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

/**
 * @author Lucian Tuca
 * @date 25/01/2018
 */
@SpringBootApplication
@Import(SwaggerConfig.class)
public class LibraryService {
    public static void main(String[] args) {
        SpringApplication.run(LibraryService.class, args);
    }
 }
