package avi.edu.dla.rand;

import java.util.Random;

public class RandomGenerator {
    private Random random = new Random();

    public int nextMove() {
        return random.nextInt(2) == 0 ? -1 : 1;
    }
}
