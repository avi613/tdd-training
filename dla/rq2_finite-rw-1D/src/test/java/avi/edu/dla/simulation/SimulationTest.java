package avi.edu.dla.simulation;

import avi.edu.dla.rand.RandomGenerator;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

public class SimulationTest {
    private RandomGenerator randomGenerator = mock(RandomGenerator.class);
    private Simulation simulation = new Simulation(randomGenerator);

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void should_not_move_particle_when_number_of_steps_is_zero() {
        assertThat(simulation.simulate(0, 36)).isEqualTo(36);
    }

    @Test
    public void should_move_particle_one_up() {
        when(randomGenerator.nextMove()).thenReturn(1);
        assertThat(simulation.simulate(1, 36)).isEqualTo(37);
    }

    @Test
    public void should_move_particle_one_down() {
        when(randomGenerator.nextMove()).thenReturn(-1);
        assertThat(simulation.simulate(1, 36)).isEqualTo(35);
    }

    @Test
    public void should_move_particle_2_up() {
        when(randomGenerator.nextMove()).thenReturn(1);
        assertThat(simulation.simulate(2, 36)).isEqualTo(38);
        verify(randomGenerator, times(2)).nextMove();
    }

    @Test
    public void should_move_particle_within_a_range() {
        // just a consistency check
        Simulation simulation = new Simulation(new RandomGenerator());
        assertThat(simulation.simulate(3, 0)).isBetween(-3, 3);
    }

    @Test
    public void should_not_except_negative_number_of_steps() {
        // security test
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("Number of steps cannot be negative");
        simulation.simulate(-1, 5);
    }
}
