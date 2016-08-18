package avi.edu.dla.simulation;


import avi.edu.dla.particle.Particle;
import avi.edu.dla.rand.RandomGenerator;
import lombok.Value;

@Value
public class Simulation {
    private RandomGenerator randomGenerator;
    private Particle finalPosition;

    public Trampoline<Particle> simulate(Particle current) {
        if (current.equals(finalPosition)) {
            System.out.println("final position reached");
            return new Trampoline<Particle>() {
                @Override
                public Particle getCurrent() {
                    return current;
                }
            };
        }

        System.out.println("current position is: " + current);

        int nextMove = randomGenerator.nextMove();
        System.out.println("next move is: " + nextMove);

        return new Trampoline<Particle>() {
            @Override
            public Trampoline<Particle> jump() {
                return simulate(new Particle(current.getX() + nextMove));
            }
        };
    }

    public static void main(String[] args) {
        final Particle FINAL_POSITION = new Particle(0);
        Simulation simulation = new Simulation(new RandomGenerator(), FINAL_POSITION);
        simulation.simulate(new Particle(1000)).run();
    }
}
