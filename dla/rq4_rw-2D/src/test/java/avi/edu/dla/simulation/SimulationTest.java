package avi.edu.dla.simulation;

import avi.edu.dla.particle.Particle;
import avi.edu.dla.rand.RandomGenerator;
import org.junit.Test;

import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

public class SimulationTest {
    private RandomGenerator randomGenerator = mock(RandomGenerator.class);
    private final Particle FINAL_POSITION = new Particle(0, 0);
    private Simulation simulation = new Simulation(randomGenerator, FINAL_POSITION);

    @Test
    public void should_not_move_particle_when_final_position_is_reached() {
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
}
