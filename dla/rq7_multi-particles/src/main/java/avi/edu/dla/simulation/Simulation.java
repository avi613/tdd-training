package avi.edu.dla.simulation;

import avi.edu.dla.boundary.Boundary;
import avi.edu.dla.movement.Movement;
import avi.edu.dla.particle.Particle;
import avi.edu.dla.rand.RandomGenerator;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

@RequiredArgsConstructor
public class Simulation {
    private final Movement movement;
    @Getter
    private final List<Particle> particles;

    public void simulate(final Particle particle, int numberOfRuns) {
        for (int i = 0; i < numberOfRuns; i++) {
            particles.add(movement.move(particle).run());
        }
    }

    public static void main(String[] args) {
        final List<Particle> particles = new LinkedList<>();
        particles.add(new Particle(0, 0));
        final Boundary boundary = new Boundary(200, 200, -200, -200);
        final Movement movement = new Movement(new RandomGenerator(new Random()), boundary, particles);

        final Simulation simulation = new Simulation(movement, particles);

        System.out.println("START SIMULATION");

        simulation.simulate(new Particle(200, 200), 1000);

        System.out.println("END SIMULATION");
        System.out.println("Report particle list");
        particles.forEach(p -> System.out.println(p));
    }
}
