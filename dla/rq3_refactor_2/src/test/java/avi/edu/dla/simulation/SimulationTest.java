package avi.edu.dla.simulation;

import avi.edu.dla.particle.Particle;
import avi.edu.dla.rand.RandomGenerator;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

public class SimulationTest {
    private RandomGenerator randomGenerator = mock(RandomGenerator.class);
    private final Particle FINAL_POSITION = new Particle(0);
    private Simulation simulation = new Simulation(randomGenerator, FINAL_POSITION);

    @Test
    public void should_not_move_particle_when_final_position_is_reached() {
        when(randomGenerator.nextMove()).thenReturn(1);
        assertThat(simulation.simulate(FINAL_POSITION).run()).isEqualTo(FINAL_POSITION);
    }

    @Test
    public void should_move_particle_one_up() {
        when(randomGenerator.nextMove()).thenReturn(1);
        assertThat(simulation.simulate(new Particle(-1)).run()).isEqualTo(FINAL_POSITION);
    }

    @Test
    public void should_move_particle_one_down() {
        when(randomGenerator.nextMove()).thenReturn(-1);
        assertThat(simulation.simulate(new Particle(1)).run()).isEqualTo(FINAL_POSITION);
    }

    @Test
    public void should_move_particle_2_up() {
        when(randomGenerator.nextMove()).thenReturn(1);
        assertThat(simulation.simulate(new Particle(-2)).run()).isEqualTo(FINAL_POSITION);
        verify(randomGenerator, times(2)).nextMove();
    }

    @Test
    public void should_move_particle_within_a_range() {
        // just a consistency check
        Simulation simulation = new Simulation(new RandomGenerator(), FINAL_POSITION);
        assertThat(simulation.simulate(new Particle(0)).run().getX()).isBetween(-3, 3);
    }
}
