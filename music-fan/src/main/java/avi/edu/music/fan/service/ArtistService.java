package avi.edu.music.fan.service;

import avi.edu.music.fan.artist.Artist;
import avi.edu.music.fan.repository.ArtistRepository;
import com.google.common.collect.ImmutableList;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ArtistService {
    private ArtistRepository artistRepository;

    public ArtistService(ArtistRepository artistRepository) {
        this.artistRepository = artistRepository;
    }

    public String sayHello() {
        return artistRepository.sayHello();
    }

    public Artist getById(String artistId) {
        return artistRepository.getById(artistId);
    }

    public List<Artist> getAllArtists() {
        return artistRepository.getAllArtists();
    }
}
