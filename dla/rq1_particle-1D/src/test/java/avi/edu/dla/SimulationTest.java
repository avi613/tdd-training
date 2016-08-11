package avi.edu.dla;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.assertj.core.api.Assertions.assertThat;

public class SimulationTest {
    private Simulation simulation = new Simulation();

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void should_not_move() {
        assertThat(simulation.movement("", 36)).isEqualTo(36);
    }

    @Test
    public void should_move_one_up() {
        assertThat(simulation.movement("+", 36)).isEqualTo(37);
    }

    @Test
    public void should_move_one_down() {
        assertThat(simulation.movement("-", 36)).isEqualTo(35);
    }

    @Test
    public void should_not_except_illegal_movement() {
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("Illegal movement found");
        simulation.movement("toto", 36);
    }

    @Test
    public void should_move_2_up() {
        assertThat(simulation.movement("++", 36)).isEqualTo(38);
    }

    @Test
    public void should_move_1_up_and_1_down() {
        assertThat(simulation.movement("+-", 36)).isEqualTo(36);
    }
}
