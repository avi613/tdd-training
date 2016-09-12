package avi.edu.music.fan.repository;

import org.springframework.stereotype.Component;

@Component
public class ArtistRepository {
    public String sayHello() {
        return "Hello You Music Fan!";
    }
}
