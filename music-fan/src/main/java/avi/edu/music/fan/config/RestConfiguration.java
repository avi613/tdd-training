package avi.edu.music.fan.config;

import avi.edu.music.fan.repository.ArtistRepository;
import avi.edu.music.fan.service.ArtistService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RestConfiguration {
    @Bean
    public ArtistRepository artistRepository() {
        return new ArtistRepository();
    }

    @Bean
    public ArtistService artistService() {
        return new ArtistService(artistRepository());
    }
}
