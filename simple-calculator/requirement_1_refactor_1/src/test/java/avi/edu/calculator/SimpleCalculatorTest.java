package avi.edu.calculator;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class SimpleCalculatorTest {
    private InputParser parser = mock(InputParser.class);
    private SimpleCalculator calculator = new SimpleCalculator(parser);

    @Test
    public void should_return_0_on_empty_string() {
        when(parser.parseToOperation("")).thenReturn(new int[]{0});
        assertThat(calculator.add("")).isEqualTo(0);
    }

    @Test
    public void should_return_0_on_blank_string() {
        when(parser.parseToOperation(" ")).thenReturn(new int[]{0});
        assertThat(calculator.add(" ")).isEqualTo(0);
    }

    @Test
    public void should_return_element_of_a_singleton() {
        when(parser.parseToOperation("8")).thenReturn(new int[]{8});
        assertThat(calculator.add("8")).isEqualTo(8);
    }

    @Test
    public void should_add_two_numbers() {
        when(parser.parseToOperation("8,10")).thenReturn(new int[]{8, 10});
        assertThat(calculator.add("8,10")).isEqualTo(18);
    }
}
