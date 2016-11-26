package avi.edu.calculator;

import avi.edu.calculator.operation.Operation;
import avi.edu.calculator.operator.*;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

public class InputParserTest {
    private OperatorFactory factory = mock(OperatorFactory.class);
    private InputParser parser = new InputParser(factory);

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void should_return_0_for_operand_operation_on_empty_string() {
        assertThat(parser.parseToOperation("").getOperands()).isEqualTo(new int[]{0});
    }

    @Test
    public void should_return_0_for_operand_operation_on_blank_string() {
        assertThat(parser.parseToOperation(" ").getOperands()).isEqualTo(new int[]{0});
    }

    @Test
    public void should_return_a_singleton_for_operand() {
        Operation expected = new Operation(new int[]{45}, new Identity());
        Operation actual = parser.parseToOperation("45");

        assertThat(actual).isEqualToComparingOnlyGivenFields(expected, "operands");
    }

    @Test
    public void should_return_an_operation_for_addition() {
        Operation expected = new Operation(new int[]{1, 2}, new Addition());
        Operation actual = parser.parseToOperation("1+2");

        assertThat(actual).isEqualToComparingOnlyGivenFields(expected, "operands");
    }

    @Test
    public void should_return_a_multiplication_operation() {
        Operation expected = new Operation(new int[]{5, 2}, new Multiplication());
        Operation actual = parser.parseToOperation("5*2");

        assertThat(actual).isEqualToComparingOnlyGivenFields(expected, "operands");
    }

    @Test
    public void should_return_a_subtraction_operation() {
        Operation expected = new Operation(new int[]{5, 2}, new Subtraction());
        Operation actual = parser.parseToOperation("5-2");

        assertThat(actual).isEqualToComparingOnlyGivenFields(expected, "operands");
    }

    @Test(expected = NumberFormatException.class)
    public void should_throw_an_exception_when_input_string_is_not_correctly_formatted() {
        parser.parseToOperation("not int input");
    }

    @Test
    public void should_throw_an_exception_when_list_length_is_greater_than_2() {
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("Cannot process more than 2 numbers");
        parser.parseToOperation("1+2+3");
    }

    @Test
    public void should_invoke_operator_factory() {
        // given
        String input = "1+2";

        // when
        parser.parseToOperation("1+2");

        // then
        verify(factory, times(1)).parseToOperator(input);
    }
}
