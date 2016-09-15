package avi.edu.music.fan.artist;

import lombok.Value;

@Value
public class Fact {
    private long postDate;
    private String postedByUser;
    private String content;
}
