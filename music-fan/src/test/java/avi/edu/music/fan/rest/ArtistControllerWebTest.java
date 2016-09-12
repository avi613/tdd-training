package avi.edu.music.fan.rest;

import avi.edu.music.fan.service.ArtistService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class ArtistControllerWebTest {
    private ArtistService artistService = mock(ArtistService.class);

    private MockMvc mockMvc = standaloneSetup(new ArtistController(artistService)).build();

    @Test
    public void should_say_hello() throws Exception {
        when(artistService.sayHello()).thenReturn("This is a unit test mocking a web rest server");

        mockMvc.perform(MockMvcRequestBuilders.get("/artists").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string(equalTo("This is a unit test mocking a web rest server")));
    }
}
