package avi.edu.music.fan.repository;

import avi.edu.music.fan.artist.Artist;
import com.google.common.collect.ImmutableBiMap;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class ArtistRepository {
    private Map<String, Artist> artists = ImmutableBiMap.of(
            "1", new Artist("1", "Serges Gainsbourg"),
            "2", new Artist("2", "Georges Brassens"),
            "3", new Artist("3", "Edit Piaf")
    );

    public String sayHello() {
        return "Hello You Music Fan!";
    }

    public Artist getById(String artistId) {
        return artists.get(artistId);
    }
}
