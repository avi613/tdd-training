package avi.edu.music.fan.service;

import avi.edu.music.fan.repository.ArtistRepository;
import org.springframework.stereotype.Component;

@Component
public class ArtistService {
    private ArtistRepository artistRepository;

    public ArtistService(ArtistRepository artistRepository) {
        this.artistRepository = artistRepository;
    }

    public String sayHello() {
        return artistRepository.sayHello();
    }
}
