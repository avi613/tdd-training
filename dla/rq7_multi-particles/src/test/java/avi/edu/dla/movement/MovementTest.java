package avi.edu.dla.movement;

import avi.edu.dla.boundary.Boundary;
import avi.edu.dla.particle.Particle;
import avi.edu.dla.rand.RandomGenerator;
import com.google.common.collect.ImmutableList;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

public class MovementTest {
    private RandomGenerator randomGenerator = mock(RandomGenerator.class);
    private Boundary boundary = mock(Boundary.class);
//    private final Particle INITIAL_PARTICLE = new Particle(0, 0);
    private final List<Particle> particles = ImmutableList.of(new Particle(0, 0));

    private Movement movement = new Movement(randomGenerator, boundary, particles);

    @Before
    public void setUp() {
        when(boundary.hasOutPassedEASTBoundary(any())).thenReturn(false);
        when(boundary.hasOutPassedNORTHBoundary(any())).thenReturn(false);
        when(boundary.hasOutPassedWESTBoundary(any())).thenReturn(false);
        when(boundary.hasOutPassedSOUTHBoundary(any())).thenReturn(false);
    }

    @Test
    public void should_stop_when_final_position_is_reached() {
        assertThat(movement.move(new Particle(1, 0)).run()).isEqualTo(new Particle(1, 0));
    }

    @Test
    public void should_move_particle_one_NORTH() {
        when(randomGenerator.nextMove()).thenReturn(new int[]{0, 1});
        assertThat(movement.move(new Particle(0, -2)).run()).isEqualTo(new Particle(0, -1));
    }

    @Test
    public void should_move_particle_one_SOUTH() {
        when(randomGenerator.nextMove()).thenReturn(new int[]{0, -1});
        assertThat(movement.move(new Particle(0, 2)).run()).isEqualTo(new Particle(0, 1));
    }

    @Test
    public void should_move_particle_one_EAST() {
        when(randomGenerator.nextMove()).thenReturn(new int[]{1, 0});
        assertThat(movement.move(new Particle(-2, 0)).run()).isEqualTo(new Particle(-1, 0));
    }

    @Test
    public void should_move_particle_one_WEST() {
        when(randomGenerator.nextMove()).thenReturn(new int[]{-1, 0});
        assertThat(movement.move(new Particle(2, 0)).run()).isEqualTo(new Particle(1, 0));
    }

    @Test
    public void should_move_particle_2_NORTH() {
        when(randomGenerator.nextMove()).thenReturn(new int[]{0, 1});
        assertThat(movement.move(new Particle(0, -3)).run()).isEqualTo(new Particle(0, -1));
        verify(randomGenerator, times(2)).nextMove();
    }

    @Test
    public void should_rebound_on_EAST_boundary() {
        when(boundary.hasOutPassedEASTBoundary(any())).thenReturn(true);
        when(boundary.getEastBoundary()).thenReturn(3);
        when(randomGenerator.nextMove()).thenReturn(new int[]{-1, 0});
        assertThat(movement.move(new Particle(4, 0)).run()).isEqualTo(new Particle(1, 0));
    }

    @Test
    public void should_rebound_on_NORTH_boundary() {
        when(boundary.hasOutPassedNORTHBoundary(any())).thenReturn(true);
        when(boundary.getNorthBoundary()).thenReturn(3);
        when(randomGenerator.nextMove()).thenReturn(new int[]{0, -1});
        assertThat(movement.move(new Particle(0, 4)).run()).isEqualTo(new Particle(0, 1));
    }

    @Test
    public void should_rebound_on_WEST_boundary() {
        when(boundary.hasOutPassedWESTBoundary(any())).thenReturn(true);
        when(boundary.getWestBoundary()).thenReturn(-3);
        when(randomGenerator.nextMove()).thenReturn(new int[]{1, 0});
        assertThat(movement.move(new Particle(-4, 0)).run()).isEqualTo(new Particle(-1, 0));
    }

    @Test
    public void should_rebound_on_SOUTH_boundary() {
        when(boundary.hasOutPassedSOUTHBoundary(any())).thenReturn(true);
        when(boundary.getSouthBoundary()).thenReturn(-3);
        when(randomGenerator.nextMove()).thenReturn(new int[]{0, 1});
        assertThat(movement.move(new Particle(0, -4)).run()).isEqualTo(new Particle(0, -1));
    }
}
