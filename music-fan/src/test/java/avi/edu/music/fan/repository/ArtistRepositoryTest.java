package avi.edu.music.fan.repository;

import avi.edu.music.fan.artist.Artist;
import com.google.common.collect.ImmutableList;
import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class ArtistRepositoryTest {
    private ArtistRepository artistRepository = new ArtistRepository();

    private List<Artist> artists = ImmutableList.of(
            new Artist("1", "Serges Gainsbourg"),
            new Artist("2", "Georges Brassens"),
            new Artist("3", "Edit Piaf")
    );

    @Test
    public void should_say_hello() {
        assertThat(artistRepository.sayHello()).isEqualTo("Hello You Music Fan!");
    }

    @Test
    public void should_get_artist_by_id() {
        assertThat(artistRepository.getById("1")).isEqualTo(artists.get(0));
        assertThat(artistRepository.getById("2")).isEqualTo(artists.get(1));
        assertThat(artistRepository.getById("3")).isEqualTo(artists.get(2));
    }

    @Test
    public void should_get_all_artists() {
        assertThat(artistRepository.getAllArtists()).isEqualTo(artists);
    }
}
