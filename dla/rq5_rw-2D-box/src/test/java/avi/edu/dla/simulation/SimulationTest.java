package avi.edu.dla.simulation;

import avi.edu.dla.boundary.Boundary;
import avi.edu.dla.particle.Particle;
import avi.edu.dla.rand.RandomGenerator;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

public class SimulationTest {
    private RandomGenerator randomGenerator = mock(RandomGenerator.class);
    private Boundary boundary = mock(Boundary.class);
    private final Particle FINAL_POSITION = new Particle(0, 0);

    private Simulation simulation = new Simulation(randomGenerator, boundary, FINAL_POSITION);

    @Before
    public void setUp() {
        when(boundary.hasOutPassedEASTBoundary(any())).thenReturn(false);
        when(boundary.hasOutPassedNORTHBoundary(any())).thenReturn(false);
        when(boundary.hasOutPassedWESTBoundary(any())).thenReturn(false);
        when(boundary.hasOutPassedSOUTHBoundary(any())).thenReturn(false);
    }

    @Test
    public void should_stop_when_final_position_is_reached() {
        when(randomGenerator.nextMove()).thenReturn(new int[]{0, 1});
        assertThat(simulation.simulate(FINAL_POSITION).run()).isEqualTo(FINAL_POSITION);
    }

    @Test
    public void should_move_particle_one_NORTH() {
        when(randomGenerator.nextMove()).thenReturn(new int[]{0, 1});
        assertThat(simulation.simulate(new Particle(0, -1)).run()).isEqualTo(FINAL_POSITION);
    }

    @Test
    public void should_move_particle_one_SOUTH() {
        when(randomGenerator.nextMove()).thenReturn(new int[]{0, -1});
        assertThat(simulation.simulate(new Particle(0, 1)).run()).isEqualTo(FINAL_POSITION);
    }

    @Test
    public void should_move_particle_one_EAST() {
        when(randomGenerator.nextMove()).thenReturn(new int[]{1, 0});
        assertThat(simulation.simulate(new Particle(-1, 0)).run()).isEqualTo(FINAL_POSITION);
    }

    @Test
    public void should_move_particle_one_WEST() {
        when(randomGenerator.nextMove()).thenReturn(new int[]{-1, 0});
        assertThat(simulation.simulate(new Particle(1, 0)).run()).isEqualTo(FINAL_POSITION);
    }

    @Test
    public void should_move_particle_2_NORTH() {
        when(randomGenerator.nextMove()).thenReturn(new int[]{0, 1});
        assertThat(simulation.simulate(new Particle(0, -2)).run()).isEqualTo(FINAL_POSITION);
        verify(randomGenerator, times(2)).nextMove();
    }

    @Test
    public void should_rebound_on_EAST_boundary() {
        when(boundary.hasOutPassedEASTBoundary(any())).thenReturn(true);
        when(randomGenerator.nextMove()).thenReturn(new int[]{1, 0});
        assertThat(simulation.simulate(new Particle(1, 0)).run()).isEqualTo(FINAL_POSITION);
    }

    @Test
    public void should_rebound_on_NORTH_boundary() {
        when(boundary.hasOutPassedNORTHBoundary(any())).thenReturn(true);
        when(randomGenerator.nextMove()).thenReturn(new int[]{0, 1});
        assertThat(simulation.simulate(new Particle(0, 1)).run()).isEqualTo(FINAL_POSITION);
    }

    @Test
    public void should_rebound_on_WEST_boundary() {
        when(boundary.hasOutPassedWESTBoundary(any())).thenReturn(true);
        when(randomGenerator.nextMove()).thenReturn(new int[]{-1, 0});
        assertThat(simulation.simulate(new Particle(-1, 0)).run()).isEqualTo(FINAL_POSITION);
    }

    @Test
    public void should_rebound_on_SOUTH_boundary() {
        when(boundary.hasOutPassedSOUTHBoundary(any())).thenReturn(true);
        when(randomGenerator.nextMove()).thenReturn(new int[]{0, -1});
        assertThat(simulation.simulate(new Particle(0, -1)).run()).isEqualTo(FINAL_POSITION);
    }
}
