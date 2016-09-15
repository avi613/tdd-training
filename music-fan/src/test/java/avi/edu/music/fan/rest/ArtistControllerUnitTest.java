package avi.edu.music.fan.rest;

import avi.edu.music.fan.artist.Artist;
import avi.edu.music.fan.rest.exception.ArtistNotFoundException;
import avi.edu.music.fan.service.ArtistService;
import com.google.common.collect.ImmutableList;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ArtistControllerUnitTest {
    private ArtistService artistService = mock(ArtistService.class);
    private ArtistController artistController = new ArtistController(artistService);

    private List<Artist> artists = ImmutableList.of(
            new Artist("neil", "Neil Young"),
            new Artist("jimi", "Jimi Hendrix"),
            new Artist("tim", "Tim Reynolds")
    );

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void should_say_hello() {
        when(artistService.sayHello()).thenReturn("This is a simple unit test");
        assertThat(artistController.sayHello()).isEqualTo("This is a simple unit test");
    }

    @Test
    public void should_get_all_artists() {
        when(artistService.getAllArtists()).thenReturn(artists);
        assertThat(artistController.getAllArtists()).isEqualTo(artists);
    }

    @Test
    public void should_get_artist_by_id() {
        when(artistService.getById(anyString())).thenReturn(artists.get(0));
        assertThat(artistController.getById(anyString())).isEqualTo(artists.get(0));
    }

    @Test
    public void should_get_artist_not_found_exception() {
        when(artistService.getById(anyString())).thenReturn(null);
        thrown.expect(ArtistNotFoundException.class);
        thrown.expectMessage("for id: bad-id");
        artistController.getById("bad-id");
    }
}
