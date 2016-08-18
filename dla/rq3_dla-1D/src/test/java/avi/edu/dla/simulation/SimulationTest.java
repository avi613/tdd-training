package avi.edu.dla.simulation;

import avi.edu.dla.rand.RandomGenerator;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

public class SimulationTest {
    private RandomGenerator randomGenerator = mock(RandomGenerator.class);
    private final int FINAL_POSITION = 0;
    private Simulation simulation = new Simulation(randomGenerator, FINAL_POSITION);

    @Test
    public void should_not_move_particle_when_final_position_is_reached() {
        when(randomGenerator.nextMove()).thenReturn(1);
        assertThat(simulation.simulate(FINAL_POSITION)).isEqualTo(FINAL_POSITION);
    }

    @Test
    public void should_move_particle_one_up() {
        when(randomGenerator.nextMove()).thenReturn(1);
        assertThat(simulation.simulate(-1)).isEqualTo(FINAL_POSITION);
    }

    @Test
    public void should_move_particle_one_down() {
        when(randomGenerator.nextMove()).thenReturn(-1);
        assertThat(simulation.simulate(1)).isEqualTo(FINAL_POSITION);
    }

    @Test
    public void should_move_particle_2_up() {
        when(randomGenerator.nextMove()).thenReturn(1);
        assertThat(simulation.simulate(-2)).isEqualTo(FINAL_POSITION);
        verify(randomGenerator, times(2)).nextMove();
    }

    @Test
    public void should_move_particle_within_a_range() {
        // just a consistency check
        Simulation simulation = new Simulation(new RandomGenerator(), FINAL_POSITION);
        assertThat(simulation.simulate(0)).isBetween(-3, 3);
    }
}
