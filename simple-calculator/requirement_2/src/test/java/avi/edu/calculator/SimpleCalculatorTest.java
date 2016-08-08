package avi.edu.calculator;

import avi.edu.calculator.operation.Operation;
import avi.edu.calculator.operator.Addition;
import avi.edu.calculator.operator.Multiplication;
import avi.edu.calculator.operator.Subtraction;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class SimpleCalculatorTest {
    private InputParser inputParser = mock(InputParser.class);
    private SimpleCalculator calculator = new SimpleCalculator(inputParser);

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void should_return_the_only_element_of_a_singleton() {
        when(inputParser.parse(anyString())).thenReturn(new Operation(new int[]{36}, new Addition()));
        assertThat(calculator.operate("36")).isEqualTo(36);
    }

    @Test
    public void should_add_two_numbers() {
        when(inputParser.parse(anyString())).thenReturn(new Operation(new int[]{36, 45}, new Addition()));
        assertThat(calculator.operate("36+45")).isEqualTo(81);
    }

    @Test
    public void should_multiply_two_numbers() {
        when(inputParser.parse(anyString())).thenReturn(new Operation(new int[]{5, 7}, new Multiplication()));
        assertThat(calculator.operate("5*7")).isEqualTo(35);
    }

    @Test
    public void should_subtract_two_numbers() {
        when(inputParser.parse(anyString())).thenReturn(new Operation(new int[]{5, 7}, new Subtraction()));
        assertThat(calculator.operate("5-7")).isEqualTo(-2);
    }
}
