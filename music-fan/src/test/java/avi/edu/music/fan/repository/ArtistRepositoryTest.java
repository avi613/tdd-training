package avi.edu.music.fan.repository;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ArtistRepositoryTest {
    private ArtistRepository artistRepository = new ArtistRepository();

    @Test
    public void should_say_hello() {
        assertThat(artistRepository.sayHello()).isEqualTo("Hello You Music Fan!");
    }
}
