package avi.edu.dla.rand;

import com.google.common.collect.ImmutableList;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Random;

@RequiredArgsConstructor
public class RandomGenerator {
    private final Random random;
    private final int NUMBER_OF_DIRECTIONS = 4;
    private final List<int[]> moves = ImmutableList.of(
            new int[]{1, 0},
            new int[]{-1, 0},
            new int[]{0, 1},
            new int[]{0, -1}
    );

    public int[] nextMove() {
        return moves.get(random.nextInt(NUMBER_OF_DIRECTIONS));
    }
}
