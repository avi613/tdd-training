package avi.edu.calculator.operator;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SubtractionTest {
    private Subtraction subtraction = new Subtraction();

    @Test
    public void should_return_the_only_element_of_a_singleton() {
        assertThat(subtraction.operate(new int[]{5})).isEqualTo(5);
    }

    @Test
    public void should_subtract_2_numbers() {
        assertThat(subtraction.operate(new int[]{6, 4})).isEqualTo(2);
        assertThat(subtraction.operate(new int[]{2, 3})).isEqualTo(-1);
    }
}
