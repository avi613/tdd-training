package avi.edu.calculator;

import avi.edu.calculator.operation.Operation;
import avi.edu.calculator.operator.Addition;
import avi.edu.calculator.operator.Identity;
import avi.edu.calculator.operator.Multiplication;
import avi.edu.calculator.operator.Subtraction;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.assertj.core.api.Assertions.assertThat;

public class InputParserTest {
    private InputParser inputParser = new InputParser();

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void should_return_an_addition() {
        assertThat(inputParser.parseOperator("1+2")).isExactlyInstanceOf(Addition.class);
    }

    @Test
    public void should_return_a_multiplication() {
        assertThat(inputParser.parseOperator("2*5")).isExactlyInstanceOf(Multiplication.class);
    }

    @Test
    public void should_return_a_subtraction() {
        assertThat(inputParser.parseOperator("2-5")).isExactlyInstanceOf(Subtraction.class);
    }

    @Test
    public void should_return_an_identity() {
        assertThat(inputParser.parseOperator("")).isExactlyInstanceOf(Identity.class);
    }

    @Test
    public void should_accept_operations_with_2_operands_or_less() {
        assertThat(inputParser.isNumberOfOperandsValid("5-3")).isTrue();
    }

    @Test
    public void should_reject_operations_with_more_then_2_operands() {
        assertThat(inputParser.isNumberOfOperandsValid("1+2+3")).isFalse();
    }

    @Test
    public void should_return_operands_as_an_array() {
        assertThat(inputParser.parseOperands("1+2")).isEqualTo(new int[]{1, 2});
        assertThat(inputParser.parseOperands("4*5")).isEqualTo(new int[]{4, 5});
        assertThat(inputParser.parseOperands("7-8")).isEqualTo(new int[]{7, 8});
    }

    @Test
    public void should_throw_an_exception_when_list_length_is_greater_than_2() {
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("Number of operands cannot be greater than 2");
        inputParser.parseOperands("1+2+3");
    }

    @Test(expected = NumberFormatException.class)
    public void should_throw_an_exception_when_input_string_is_not_correctly_formatted() {
        inputParser.parse("any string");
    }

    @Test
    public void should_return_a_null_operand_operation() {
        Operation empty = inputParser.parse("");
        assertThat(empty.getOperands()).isEqualTo(null);
        assertThat(empty.getOperator()).isExactlyInstanceOf(Identity.class);

        Operation blank = inputParser.parse("      ");
        assertThat(blank.getOperands()).isEqualTo(null);
        assertThat(blank.getOperator()).isExactlyInstanceOf(Identity.class);
    }

    @Test
    public void should_return_an_operation_singleton() {
        Operation expected = new Operation(new int[]{45}, new Identity());
        Operation actual = inputParser.parse("    45      ");

        assertThat(actual).isEqualToComparingOnlyGivenFields(expected, "operands");
        assertThat(actual.getOperator()).isExactlyInstanceOf(expected.getOperator().getClass());
    }

    @Test
    public void should_return_an_operation_for_addition() {
        Operation expected = new Operation(new int[]{1, 2}, new Addition());
        Operation actual = inputParser.parse("1+2");

        assertThat(actual).isEqualToComparingOnlyGivenFields(expected, "operands");
        assertThat(actual.getOperator()).isExactlyInstanceOf(expected.getOperator().getClass());
    }

    @Test
    public void should_return_a_multiplication_operation() {
        Operation expected = new Operation(new int[]{5, 2}, new Multiplication());
        Operation actual = inputParser.parse("5*2");

        assertThat(actual).isEqualToComparingOnlyGivenFields(expected, "operands");
        assertThat(actual.getOperator()).isExactlyInstanceOf(expected.getOperator().getClass());
    }

    @Test
    public void should_return_a_subtraction_operation() {
        Operation expected = new Operation(new int[]{5, 2}, new Subtraction());
        Operation actual = inputParser.parse("5-2");

        assertThat(actual).isEqualToComparingOnlyGivenFields(expected, "operands");
        assertThat(actual.getOperator()).isExactlyInstanceOf(expected.getOperator().getClass());
    }
}
