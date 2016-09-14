package avi.edu.music.fan.artist;

import com.fasterxml.jackson.annotation.JsonView;
import lombok.Value;

@Value
public class Artist {
    @JsonView(ArtistView.class)
    private String id;
    @JsonView(ArtistView.class)
    private String name;
}
