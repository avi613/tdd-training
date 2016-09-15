package avi.edu.music.fan.repository;

import avi.edu.music.fan.artist.Artist;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static avi.edu.music.fan.repository.ArtistDB.data;

@Component
public class ArtistRepository {
    private Map<String, Artist> artists = data();

    public String sayHello() {
        return "Hello You Music Fan!";
    }

    public Artist getById(String artistId) {
        return artists.get(artistId);
    }

    public List<Artist> getAllArtists() {
        return artists.values().stream().collect(Collectors.toList());
    }
}
