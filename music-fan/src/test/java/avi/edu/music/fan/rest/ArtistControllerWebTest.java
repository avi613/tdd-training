package avi.edu.music.fan.rest;

import avi.edu.music.fan.artist.Artist;
import avi.edu.music.fan.service.ArtistService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.List;

import static avi.edu.music.fan.MockDB.mockData;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.mockito.Matchers.anyString;
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

    private List<Artist> artists = mockData();

    @Test
    public void should_say_hello() throws Exception {
        when(artistService.sayHello()).thenReturn("This is a unit test mocking a web rest server");

        mockMvc.perform(MockMvcRequestBuilders.get("/artists/hello").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string(equalTo("This is a unit test mocking a web rest server")));
    }

    @Test
    public void should_get_all_artists() throws Exception {
        when(artistService.getAllArtists()).thenReturn(artists);

        mockMvc.perform(MockMvcRequestBuilders.get("/artists").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().json("[{\"id\":\"neil\",\"name\":\"Neil Young\"},{\"id\":\"jimi\",\"name\":\"Jimi Hendrix\"},{\"id\":\"tim\",\"name\":\"Tim Reynolds\"}]"));
    }

    @Test
    public void should_get_artist_by_id() throws Exception {
        when(artistService.getById(anyString())).thenReturn(artists.get(1));

        mockMvc.perform(MockMvcRequestBuilders.get("/artists/whateverId").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().json("{id: jimi, name: Jimi Hendrix}"));
    }

    @Test
    public void should_get_not_found_status() throws Exception {
        when(artistService.getById(anyString())).thenReturn(null);
        mockMvc.perform(MockMvcRequestBuilders.get("/artists/bad-id").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());
    }
}
