package avi.edu.calculator;

import avi.edu.calculator.operation.Operation;
import avi.edu.calculator.operator.Addition;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.assertj.core.api.Assertions.assertThat;

public class InputParserTest {
    private InputParser inputParser = new InputParser();

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void should_return_0_for_operand_operation_on_empty_string() {
        assertThat(inputParser.parseToOperation("").getOperands()).isEqualTo(new int[]{0});
    }

    @Test
    public void should_return_0_for_operand_operation_on_blank_string() {
        assertThat(inputParser.parseToOperation(" ").getOperands()).isEqualTo(new int[]{0});
    }

    @Test
    public void should_return_a_singleton_for_operand() {
        Operation expected = new Operation(new int[]{45}, new Addition());
        Operation actual = inputParser.parseToOperation("45");

        assertThat(actual).isEqualToComparingOnlyGivenFields(expected, "operands");
        assertThat(actual.getOperator()).isExactlyInstanceOf(expected.getOperator().getClass());
    }

    @Test
    public void should_return_an_operation_for_addition() {
        Operation expected = new Operation(new int[]{1, 2}, new Addition());
        Operation actual = inputParser.parseToOperation("1,2");

        assertThat(actual).isEqualToComparingOnlyGivenFields(expected, "operands");
        assertThat(actual.getOperator()).isExactlyInstanceOf(expected.getOperator().getClass());
    }


    @Test(expected = NumberFormatException.class)
    public void should_throw_an_exception_when_input_string_is_not_correctly_formatted() {
        inputParser.parseToOperation("not int input");
    }

    @Test
    public void should_throw_an_exception_when_list_length_is_greater_than_2() {
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("Cannot process more than 2 numbers");
        inputParser.parseToOperation("1,2,3");
    }
}
