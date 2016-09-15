package avi.edu.music.fan.repository;

import avi.edu.music.fan.artist.Artist;
import avi.edu.music.fan.artist.Fact;
import com.google.common.collect.ImmutableBiMap;
import com.google.common.collect.ImmutableList;

import java.util.Date;
import java.util.Map;

public class ArtistDB {
    private static Map<String, Artist> artists = ImmutableBiMap.of(
            "1", new Artist("1", "Serges Gainsbourg", ImmutableList.of(
                    new Fact(1473975159088L, "Coco", "Il a eu de nombreux styles musicaux"),
                    new Fact(1473975159068L, "Edouard", "Il a tout de même brûlé un billet de 500 balles!")
            )),
            "2", new Artist("2", "Georges Brassens", ImmutableList.of(
                    new Fact(1473975159088L, "Nostalgie", "Garre au Brassens"),
                    new Fact(1473975159068L, "Nostalgie", "Il a su nous faire réfléchir")
            )),
            "3", new Artist("3", "Edit Piaf", ImmutableList.of(
                    new Fact(1473975264112L, "jiji21", "Elle a chanté à L\'Olympia")
            )),
            "4", new Artist("4", "Neil Young", ImmutableList.of(
                    new Fact(1473975159088L, "Beat Nick", "He is Canadian")
            )),
            "5", new Artist("5", "Jimi Hendrix", ImmutableList.of(
                    new Fact(1473975159068L, "Harlem", "He was born in Seatle")
            ))
    );

    public static Map<String, Artist> data() {
        return artists;
    }
}
