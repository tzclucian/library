package tzc.library;

import static org.springframework.test.util.AssertionErrors.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.util.UriComponentsBuilder;

/**
 * @author Lucian Tuca
 * @date 29/01/2018
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = LibraryService.class, webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class BookControllerIT {

    private static final Logger LOGGER = LoggerFactory.getLogger(BookControllerIT.class);

    @Autowired
    private TestRestTemplate testRestTemplate;

    @Value("${server.baseUrl}")
    private String baseUrl;

    @Test
    public void exampleTest() {
        LOGGER.info("Starting the test.");

        Book book = new Book();
        book.setId("1234");
        book.setAuthor("Lucian");
        book.setContent("A lot of stuff here");

        final TestRestTemplate restTemplate = new TestRestTemplate();
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("myCustomHeader", "myCustomValue");
        HttpEntity<Book> requestEntity = new HttpEntity<Book>(book, httpHeaders);


        String requestUrl = baseUrl + "/book/example/" + book.getId();
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(requestUrl)
                .queryParam("queryParam1", "queryParamValue1");

        ResponseEntity<Book> bookResponseEntity = restTemplate.postForEntity(
                builder.build().encode().toUri(),
                requestEntity,
                Book.class
        );

        Book bookFromResponse = bookResponseEntity.getBody();

        LOGGER.info("Done the request. Code: " + bookResponseEntity.getStatusCode());
        assertEquals("Status should be 200", HttpStatus.OK.value(), bookResponseEntity.getStatusCode().value());
    }
}
