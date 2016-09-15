package avi.edu.music.fan.repository;

import avi.edu.music.fan.artist.Artist;
import com.google.common.collect.ImmutableBiMap;

import java.util.Map;

public class ArtistDB {
    private static Map<String, Artist> artists = ImmutableBiMap.of(
            "1", new Artist("1", "Serges Gainsbourg"),
            "2", new Artist("2", "Georges Brassens"),
            "3", new Artist("3", "Edit Piaf")
    );

    public static Map<String, Artist> data() {
        return artists;
    }
}
