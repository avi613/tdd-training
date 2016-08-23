package avi.edu.dla.simulation;

import avi.edu.dla.boundary.Boundary;
import avi.edu.dla.movement.Movement;
import avi.edu.dla.particle.Particle;
import avi.edu.dla.rand.RandomGenerator;
import lombok.RequiredArgsConstructor;

import java.util.Random;

@RequiredArgsConstructor
public class Simulation {
    private final Movement movement;

    public void simulate(final Particle particle) {
        movement.move(particle).run();
    }

    public static void main(String[] args) {
        final Particle INITIAL_PARTICLE = new Particle(0, 0);
        final Boundary boundary = new Boundary(100, 100, -100, -100);
        final Movement movement = new Movement(new RandomGenerator(new Random()), boundary, INITIAL_PARTICLE);

        final Simulation simulation = new Simulation(movement);

        System.out.println("START SIMULATION");

        simulation.simulate(new Particle(100, 100));
    }
}
