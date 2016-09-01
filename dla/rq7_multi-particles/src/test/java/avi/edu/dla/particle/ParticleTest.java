package avi.edu.dla.particle;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ParticleTest {
    private Particle moving = new Particle(0, 0);

    @Test
    public void should_touch_particle_EAST() {
        Particle stationary = new Particle(1, 0);
        assertThat(moving.touches(stationary)).isTrue();
    }

    @Test
    public void should_touch_particle_NORTH() {
        Particle stationary = new Particle(0, 1);
        assertThat(moving.touches(stationary)).isTrue();
    }

    @Test
    public void should_touch_particle_WEST() {
        Particle stationary = new Particle(-1, 0);
        assertThat(moving.touches(stationary)).isTrue();
    }

    @Test
    public void should_touch_particle_SOUTH() {
        Particle stationary = new Particle(0, -1);
        assertThat(moving.touches(stationary)).isTrue();
    }

    @Test
    public void should_not_touch_particle() {
        Particle stationary = new Particle(1, 1);
        assertThat(moving.touches(stationary)).isFalse();
    }
}
