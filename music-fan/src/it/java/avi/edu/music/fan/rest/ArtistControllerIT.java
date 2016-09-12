package avi.edu.music.fan.rest;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.net.MalformedURLException;
import java.net.URL;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment =  SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ArtistControllerIT {
    @LocalServerPort
    private int port;
    private URL base;
    @Autowired
    private TestRestTemplate restTemplate = new TestRestTemplate();

    @Before
    public void setUp() throws MalformedURLException {
        this.base = new URL("http://localhost:" + port + "/artists");
    }

    @Test
    public void should_say_hello() {
        ResponseEntity<String> response = restTemplate.getForEntity(base.toString(), String.class);
        assertThat(response.getBody()).isEqualTo("Hello You Music Fan!");
    }
}
