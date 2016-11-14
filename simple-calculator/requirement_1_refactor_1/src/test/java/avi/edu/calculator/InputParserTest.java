package avi.edu.calculator;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.assertj.core.api.Assertions.assertThat;

public class InputParserTest {
    private InputParser inputParser = new InputParser();

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void should_return_an_empty_array() {
        assertThat(inputParser.parse("")).isEmpty();
    }

    @Test
    public void should_return_an_array_of_ints() {
        assertThat(inputParser.parse("1,2")).isEqualTo(new int[]{1, 2});
    }

    @Test
    public void should_return_a_singleton() {
        assertThat(inputParser.parse("    45      ")).isEqualTo(new int[]{45});
    }

    @Test(expected = NumberFormatException.class)
    public void should_throw_an_exception_when_input_string_is_not_correctly_formatted() {
        inputParser.parse("any string");
    }

    @Test
    public void should_throw_an_exception_when_list_length_is_greater_than_2() {
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("Number of operands cannot be greater than 2");
        inputParser.parse("1,2,3");
    }
}
