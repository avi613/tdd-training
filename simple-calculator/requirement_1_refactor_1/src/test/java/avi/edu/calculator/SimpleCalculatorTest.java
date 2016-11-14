package avi.edu.calculator;

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
    public void should_return_0_when_input_is_empty() {
        when(inputParser.parse(anyString())).thenReturn(new int[] {});
        assertThat(calculator.add("")).isEqualTo(0);
    }

    @Test
    public void should_return_0_when_input_is_blank() {
        when(inputParser.parse(anyString())).thenReturn(new int[] {});
        assertThat(calculator.add("   ")).isEqualTo(0);
    }

    @Test
    public void should_return_the_only_element_of_a_singleton() {
        when(inputParser.parse(anyString())).thenReturn(new int[]{36});
        assertThat(calculator.add("36")).isEqualTo(36);
    }

    @Test
    public void should_add_two_numbers() {
        when(inputParser.parse(anyString())).thenReturn(new int[]{36, 45});
        assertThat(calculator.add("36, 45")).isEqualTo(81);
    }

    @Test
    public void it_should_subtract_negative_numbers() {
        when(inputParser.parse(anyString())).thenReturn(new int[]{1, -2});
        assertThat(calculator.add("1,-2")).isEqualTo(-1);
    }
}
