package avi.edu.dla.simulation;

import avi.edu.dla.rand.RandomGenerator;
import lombok.Value;

@Value
public class Simulation {
    private RandomGenerator randomGenerator;
    private Integer finalPosition;

    public Trampoline<Integer> simulate(Integer current) {
        if (current.equals(finalPosition)) {
            System.out.println("final position reached");
            return new Trampoline<Integer>() {
                @Override
                public Integer getCurrent() {
                    return current;
                }
            };
        }

        System.out.println("current position is: " + current);

        int nextMove = randomGenerator.nextMove();
        System.out.println("next move is: " + nextMove);

        return new Trampoline<Integer>() {
            @Override
            public Trampoline<Integer> jump() {
                return simulate(current + nextMove);
            }
        };
    }

    public static void main(String[] args) {
        final Integer FINAL_POSITION = 0;
        Simulation simulation = new Simulation(new RandomGenerator(), FINAL_POSITION);
        simulation.simulate(1000).run();
    }
}
