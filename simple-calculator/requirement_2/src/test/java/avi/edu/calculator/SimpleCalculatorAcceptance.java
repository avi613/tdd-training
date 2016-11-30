package avi.edu.calculator;

import avi.edu.calculator.operator.OperatorFactory;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.assertj.core.api.Assertions.assertThat;

public class SimpleCalculatorAcceptance {
    private InputParser parser = new InputParser(new OperatorFactory());
    private SimpleCalculator calculator = new SimpleCalculator(parser);

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void should_add_two_numbers() {
        assertThat(calculator.operate("1+2")).isEqualTo(3);
    }

    @Test
    public void should_subtract_two_numbers() {
        assertThat(calculator.operate("1-2")).isEqualTo(-1);
    }

    @Test
    public void should_multiply_two_numbers() {
        assertThat(calculator.operate("3*2")).isEqualTo(6);
    }

    @Test
    public void should_return_a_singleton() {
        assertThat(calculator.operate("36")).isEqualTo(36);
    }

    @Test
    public void should_return_zero_on_empty_input() {
        assertThat(calculator.operate("")).isEqualTo(0);
    }

    @Test
    public void should_return_zero_on_blank_input() {
        assertThat(calculator.operate("    ")).isEqualTo(0);
    }

    @Test(expected = NumberFormatException.class)
    public void should_reject_non_integer_operands() {
        calculator.operate("1.0-un truc");
    }

    @Test
    public void should_reject_operations_with_more_than_two_operands() {
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("Cannot process more than 2 numbers");
        parser.parseToOperation("1+2+3");
    }

    @Test
    public void should_reject_unsupported_operations() {
        thrown.expect(UnsupportedOperationException.class);
        thrown.expectMessage("unsupported operation: 1/2");
        parser.parseToOperation("1/2");
    }
}
