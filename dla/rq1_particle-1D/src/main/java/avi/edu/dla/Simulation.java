package avi.edu.dla;

public class Simulation {
    public int movement(String input, int current) {
        System.out.println("current position is: " + current);
        if (input.trim().isEmpty())
            return current;

        if (!(input.trim().endsWith("+") || input.trim().endsWith("-")))
            throw new IllegalArgumentException("Illegal movement found");

        System.out.println("next move is: " + nextMove(input));

        return movement(input.trim().substring(1), current + nextMove(input));
    }

    private int nextMove(String input) {
        return input.trim().startsWith("+") ? 1 : -1;
    }

    public static void main(String[] args) {
        Simulation simulation = new Simulation();
        simulation.movement("+++---+-+---++----+---", 45);
    }
}
