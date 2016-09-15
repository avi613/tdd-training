package avi.edu.music.fan.artist;

import com.fasterxml.jackson.annotation.JsonView;
import lombok.Value;

import java.util.List;

@Value
public class Artist {
    @JsonView(ArtistPreview.class)
    private String id;
    @JsonView(ArtistPreview.class)
    private String name;

    private List<Fact> facts;
}
