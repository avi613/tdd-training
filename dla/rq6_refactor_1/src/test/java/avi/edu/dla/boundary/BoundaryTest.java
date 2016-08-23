package avi.edu.dla.boundary;

import avi.edu.dla.particle.Particle;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class BoundaryTest {
    private final int EAST_BOUNDARY = 10;
    private final int NORTH_BOUNDARY = 8;
    private final int WEST_BOUNDARY = -32;
    private final int SOUTH_BOUNDARY = -15;

    private Boundary boundary = new Boundary(EAST_BOUNDARY, NORTH_BOUNDARY, WEST_BOUNDARY, SOUTH_BOUNDARY);

    @Test
    public void should_do_nothing_if_particle_is_within_boundaries() {
        assertThat(boundary.hasOutPassedEASTBoundary(new Particle(5, 5))).isFalse();
        assertThat(boundary.hasOutPassedNORTHBoundary(new Particle(5, 5))).isFalse();
        assertThat(boundary.hasOutPassedWESTBoundary(new Particle(5, 5))).isFalse();
        assertThat(boundary.hasOutPassedSOUTHBoundary(new Particle(5, 5))).isFalse();
    }

    @Test
    public void should_return_true_when_EAST_boundary_is_out_passed() {
        assertThat(boundary.hasOutPassedEASTBoundary(new Particle(EAST_BOUNDARY + 1, 0))).isTrue();
    }

    @Test
    public void should_return_true_when_NORTH_boundary_is_out_passed() {
        assertThat(boundary.hasOutPassedNORTHBoundary(new Particle(0, NORTH_BOUNDARY + 1))).isTrue();
    }

    @Test
    public void should_return_true_when_WEST_boundary_is_out_passed() {
        assertThat(boundary.hasOutPassedWESTBoundary(new Particle(WEST_BOUNDARY - 1, 0))).isTrue();
    }

    @Test
    public void should_return_true_when_SOUTH_boundary_is_out_passed() {
        assertThat(boundary.hasOutPassedSOUTHBoundary(new Particle(0, SOUTH_BOUNDARY - 1))).isTrue();
    }
}
