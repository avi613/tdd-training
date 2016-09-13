package avi.edu.music.fan.rest;

import avi.edu.music.fan.artist.Artist;
import avi.edu.music.fan.rest.exception.ArtistNotFoundException;
import avi.edu.music.fan.service.ArtistService;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ArtistControllerUnitTest {
    ArtistService artistService = mock(ArtistService.class);
    ArtistController artistController = new ArtistController(artistService);

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void should_say_hello() {
        when(artistService.sayHello()).thenReturn("This is a simple unit test");
        assertThat(artistController.sayHello()).isEqualTo("This is a simple unit test");
    }

    @Test
    public void should_get_artist_by_id() {
        Artist neil = new Artist("neil", "Neil Young");
        when(artistService.getById(anyString())).thenReturn(neil);
        assertThat(artistController.getById(anyString())).isEqualTo(neil);
    }

    @Test
    public void should_get_artist_not_found_exception() {
        when(artistService.getById(anyString())).thenReturn(null);
        thrown.expect(ArtistNotFoundException.class);
        thrown.expectMessage("for id: bad-id");
        artistController.getById("bad-id");
    }
}
