package avi.edu.music.fan;

import avi.edu.music.fan.artist.Artist;
import avi.edu.music.fan.artist.Fact;
import com.google.common.collect.ImmutableList;

import java.util.Date;
import java.util.List;

public class MockDB {
    private static List<Artist> artists = ImmutableList.of(
            new Artist("neil", "Neil Young", ImmutableList.of(
                    new Fact(new Date().getTime(), "Beat Nick", "He is Canadian")
            )),
            new Artist("jimi", "Jimi Hendrix", ImmutableList.of(
                    new Fact(new Date().getTime(), "Harlem", "He was born in Seatle")
            )),
            new Artist("tim", "Tim Reynolds", ImmutableList.of(
                    new Fact(new Date().getTime(), "Dave", "He says funny things while playing")
            ))
    );

    public static List<Artist> mockData() {
        return artists;
    }
}
