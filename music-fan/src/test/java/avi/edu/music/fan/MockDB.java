package avi.edu.music.fan;

import avi.edu.music.fan.artist.Artist;
import com.google.common.collect.ImmutableList;

import java.util.List;

public class MockDB {
    private static List<Artist> artists = ImmutableList.of(
            new Artist("neil", "Neil Young"),
            new Artist("jimi", "Jimi Hendrix"),
            new Artist("tim", "Tim Reynolds")
    );

    public static List<Artist> mockData() {
        return artists;
    }
}
