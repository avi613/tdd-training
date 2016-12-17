package avi.edu.rappersdelight.rest;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.net.MalformedURLException;
import java.net.URL;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class RappersControllerIT {
    @LocalServerPort
    private int port;
    private URL baseUrl;
    @Autowired
    private TestRestTemplate restTemplate;

    @Before
    public void setUp() throws MalformedURLException {
        baseUrl = new URL("http://localhost:" + port + "/rappers-delight/rappers");
    }

    @Test
    public void should_get_all_rappers_previews() {
        ResponseEntity<String> response = restTemplate.getForEntity(baseUrl.toString(), String.class);
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody()).isEqualTo("[{\"id\":\"1\",\"name\":\"Red Man\"},{\"id\":\"2\",\"name\":\"Method Man\"}]");
    }

    @Test
    public void should_get_rappers_by_id() {
        ResponseEntity<String> response = restTemplate.getForEntity(baseUrl.toString() + "/1", String.class);
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody()).isEqualTo("{\"id\":\"1\",\"name\":\"Red Man\"}");
    }

    @Test
    public void should_get_a_rapper_not_found() {
        ResponseEntity<String> response = restTemplate.getForEntity(baseUrl.toString() + "/3", String.class);
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.NOT_FOUND);
        assertThat(response.getBody()).contains("\"message\":\"Rapper with id: 3 not found\"");
    }
}
