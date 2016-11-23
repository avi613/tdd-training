package avi.edu.calculator;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.assertj.core.api.Assertions.assertThat;

public class InputParserTest {
    private InputParser parser = new InputParser();

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void should_return_array_containing_0_on_empty_string() {
        assertThat(parser.parseToOperation("")).isEqualTo(new int[]{0});
    }

    @Test
    public void should_return_array_containing_0_on_blank_string() {
        assertThat(parser.parseToOperation(" ")).isEqualTo(new int[]{0});
    }

    @Test
    public void should_return_a_singleton() {
        assertThat(parser.parseToOperation("8")).isEqualTo(new int[]{8});
    }


    @Test
    public void should_return_an_array_of_two_numbers() {
        assertThat(parser.parseToOperation("4,5")).isEqualTo(new int[]{4, 5});
    }

    @Test(expected = NumberFormatException.class)
    public void should_reject_non_integer_input() {
        parser.parseToOperation("a non int input");
    }


    @Test
    public void should_reject_inputs_with_more_than_2_numbers() {
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("Cannot process more than 2 numbers");
        parser.parseToOperation("1,2,3");
    }
}
