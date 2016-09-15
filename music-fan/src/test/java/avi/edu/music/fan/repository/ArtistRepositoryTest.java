package avi.edu.music.fan.repository;

import avi.edu.music.fan.artist.Artist;
import avi.edu.music.fan.artist.Fact;
import com.google.common.collect.ImmutableList;
import org.junit.Test;

import java.util.Date;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class ArtistRepositoryTest {
    private ArtistRepository artistRepository = new ArtistRepository();

    private List<Artist> artists = ImmutableList.of(
            new Artist("1", "Serges Gainsbourg", ImmutableList.of(
                    new Fact(1473975159088L, "Coco", "Il a eu de nombreux styles musicaux"),
                    new Fact(1473975159068L, "Edouard", "Il a tout de même brûlé un billet de 500 balles!")
            )),
            new Artist("2", "Georges Brassens", ImmutableList.of(
                    new Fact(1473975159088L, "Nostalgie", "Garre au Brassens"),
                    new Fact(1473975159068L, "Nostalgie", "Il a su nous faire réfléchir")
            )),
            new Artist("3", "Edit Piaf", ImmutableList.of(
                    new Fact(1473975264112L, "jiji21", "Elle a chanté à L\'Olympia")
            )),
            new Artist("4", "Neil Young", ImmutableList.of(
                    new Fact(1473975159088L, "Beat Nick", "He is Canadian")
            )),
            new Artist("5", "Jimi Hendrix", ImmutableList.of(
                    new Fact(1473975159068L, "Harlem", "He was born in Seatle")
            ))
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
