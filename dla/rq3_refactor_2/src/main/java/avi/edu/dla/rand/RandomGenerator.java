package avi.edu.dla.rand;

import com.google.common.collect.ImmutableList;

import java.util.List;
import java.util.Random;

public class RandomGenerator {
    private Random random = new Random();
    private List<Integer> moves = ImmutableList.of(-1, 1);

    public int nextMove() {
        return moves.get(random.nextInt(2));
    }
}
