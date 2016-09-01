package avi.edu.dla.simulation;

import avi.edu.dla.movement.Movement;
import avi.edu.dla.movement.Trampoline;
import avi.edu.dla.particle.Particle;
import com.google.common.collect.ImmutableList;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class SimulationTest {
    private Movement movement = mock(Movement.class);
    private final List<Particle> particles = new ArrayList<>();
    private Simulation simulation = new Simulation(movement, particles);

    @Before
    public void setUp() {
        particles.add(new Particle(0, 0));
    }

    @Test
    public void should_contain_2_particles_for_one_simulation_run() {
        Trampoline<Particle> tParticle = mock(Trampoline.class);
        when(tParticle.run()).thenReturn(new Particle(1, 0));
        when(movement.move(any())).thenReturn(tParticle);
        simulation.simulate(new Particle(45, 36), 1);
        assertThat(simulation.getParticles().size()).isEqualTo(2);
        assertThat(simulation.getParticles()).contains(new Particle(0, 0), new Particle(1, 0));
    }

    @Test
    public void should_contain_3_particles_for_two_simulation_runs() {
        Trampoline<Particle> tParticle = mock(Trampoline.class);
        when(tParticle.run()).thenReturn(new Particle(1, 0));
        when(movement.move(any())).thenReturn(tParticle);
        simulation.simulate(new Particle(45, 36), 2);
        assertThat(simulation.getParticles().size()).isEqualTo(3);
        assertThat(simulation.getParticles()).contains(new Particle(0, 0), new Particle(1, 0));
    }
}
