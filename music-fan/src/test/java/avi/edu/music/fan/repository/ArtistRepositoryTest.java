package avi.edu.music.fan.repository;

import avi.edu.music.fan.artist.Artist;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ArtistRepositoryTest {
    private ArtistRepository artistRepository = new ArtistRepository();

    @Test
    public void should_say_hello() {
        assertThat(artistRepository.sayHello()).isEqualTo("Hello You Music Fan!");
    }

    @Test
    public void should_get_artist_by_id() {
        assertThat(artistRepository.getById("1")).isEqualTo(new Artist("1", "Serges Gainsbourg"));
        assertThat(artistRepository.getById("2")).isEqualTo(new Artist("2", "Georges Brassens"));
        assertThat(artistRepository.getById("3")).isEqualTo(new Artist("3", "Edit Piaf"));
    }
}
