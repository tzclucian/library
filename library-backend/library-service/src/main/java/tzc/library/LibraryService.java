package tzc.library;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

/**
 * The Library service.
 *
 * @author Lucian Tuca
 * created on 25/01/2018
 */
@SpringBootApplication(scanBasePackages = "tzc.library")
@Import({SwaggerConfig.class, CorsConfiguration.class})
public class LibraryService {
    public static void main(String[] args) {
        SpringApplication.run(LibraryService.class, args);
    }
 }
