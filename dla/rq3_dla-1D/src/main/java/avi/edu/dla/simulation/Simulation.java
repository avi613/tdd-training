package avi.edu.dla.simulation;

import avi.edu.dla.rand.RandomGenerator;
import lombok.Value;

@Value
public class Simulation {
    private RandomGenerator randomGenerator;
    private int finalPosition;

    public int simulate(int current) {
        if (current == finalPosition)
            return current;

        System.out.println("current position is: " + current);

        int nextMove = randomGenerator.nextMove();
        System.out.println("next move is: " + nextMove);

        return simulate(current + nextMove);
    }

    public static void main(String[] args) {
        final int FINAL_POSITION = 0;
        Simulation simulation = new Simulation(new RandomGenerator(), FINAL_POSITION);
        simulation.simulate(10);
    }
}
