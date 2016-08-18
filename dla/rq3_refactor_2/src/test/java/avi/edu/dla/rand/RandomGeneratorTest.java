package avi.edu.dla.rand;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RandomGeneratorTest {
    private RandomGenerator randomGenerator = new RandomGenerator();

    @Test
    public void should_return_one_or_minus_one() {
        assertThat(randomGenerator.nextMove()).matches(nextMove -> nextMove == 1 || nextMove == -1);
    }
}
