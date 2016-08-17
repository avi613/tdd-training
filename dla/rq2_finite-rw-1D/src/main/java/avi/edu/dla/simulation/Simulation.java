package avi.edu.dla.simulation;

import avi.edu.dla.rand.RandomGenerator;
import lombok.Value;

@Value
public class Simulation {
    private RandomGenerator randomGenerator;

    public int simulate(int numberOfSteps, int current) {
        if (numberOfSteps < 0)
            throw new IllegalArgumentException("Number of steps cannot be negative");

        System.out.println("current step is: " + numberOfSteps);
        System.out.println("current position is: " + current);
        int nextMove = randomGenerator.nextMove();
        System.out.println("next move is: " + nextMove);

        if (numberOfSteps == 0)
            return current;
        return simulate(numberOfSteps - 1, current + nextMove);
    }

    public static void main(String[] args) {
        Simulation simulation = new Simulation(new RandomGenerator());
        simulation.simulate(20, 36);
    }
}
