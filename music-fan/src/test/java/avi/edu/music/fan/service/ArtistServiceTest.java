package avi.edu.music.fan.service;

import avi.edu.music.fan.artist.Artist;
import avi.edu.music.fan.repository.ArtistRepository;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ArtistServiceTest {
    private ArtistRepository artistRepository = mock(ArtistRepository.class);
    private ArtistService artistService = new ArtistService(artistRepository);

    @Test
    public void should_say_hello() {
        when(artistRepository.sayHello()).thenReturn("This demonstrate layers implementation using TDD");
        assertThat(artistService.sayHello()).isEqualTo("This demonstrate layers implementation using TDD");
    }

    @Test
    public void should_get_artist_by_id() {
        Artist robert = new Artist("artistId", "Robert Johnson");
        when(artistRepository.getById(anyString())).thenReturn(robert);
        assertThat(artistService.getById(anyString())).isEqualTo(robert);
    }
}
