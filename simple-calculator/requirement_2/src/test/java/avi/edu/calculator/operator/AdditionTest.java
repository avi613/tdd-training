package avi.edu.calculator.operator;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class AdditionTest {
    private Addition addition = new Addition();

    @Test
    public void should_return_0_when_input_is_null() {
        assertThat(addition.operate(null)).isEqualTo(0);
    }

    @Test
    public void should_return_the_only_element_of_a_singleton() {
        assertThat(addition.operate(new int[]{5})).isEqualTo(5);
    }

    @Test
    public void should_add_2_numbers() {
        assertThat(addition.operate(new int[]{1, 2})).isEqualTo(3);
        assertThat(addition.operate(new int[]{2, 3})).isEqualTo(5);
    }
}
