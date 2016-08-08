package avi.edu.calculator.operator;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MultiplicationTest {
    private Multiplication multiplication = new Multiplication();

    @Test
    public void should_return_0_when_input_is_null() {
        assertThat(multiplication.operate(null)).isEqualTo(0);
    }

    @Test
    public void should_return_the_only_element_of_a_singleton() {
        assertThat(multiplication.operate(new int[]{5})).isEqualTo(5);
    }

    @Test
    public void should_multiply_2_numbers() {
        assertThat(multiplication.operate(new int[]{6, 4})).isEqualTo(24);
        assertThat(multiplication.operate(new int[]{2, 3})).isEqualTo(6);
    }
}
