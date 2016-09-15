package avi.edu.music.fan.service;

import avi.edu.music.fan.artist.Artist;
import avi.edu.music.fan.repository.ArtistRepository;
import com.google.common.collect.ImmutableList;
import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ArtistServiceTest {
    private ArtistRepository artistRepository = mock(ArtistRepository.class);
    private ArtistService artistService = new ArtistService(artistRepository);

    private List<Artist> artists = ImmutableList.of(
            new Artist("bob", "Robert Johnson"),
            new Artist("mud", "Muddy Blues"),
            new Artist("jon", "John Lee Hooker")
    );

    @Test
    public void should_say_hello() {
        when(artistRepository.sayHello()).thenReturn("This demonstrate layers implementation using TDD");
        assertThat(artistService.sayHello()).isEqualTo("This demonstrate layers implementation using TDD");
    }

    @Test
    public void should_get_all_artists() {
        when(artistRepository.getAllArtists()).thenReturn(artists);
        assertThat(artistService.getAllArtists()).isEqualTo(artists);
    }

    @Test
    public void should_get_artist_by_id() {
        when(artistRepository.getById(anyString())).thenReturn(artists.get(0));
        assertThat(artistService.getById(anyString())).isEqualTo(artists.get(0));
    }
}
