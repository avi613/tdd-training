package avi.edu.calculator.operator;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.assertj.core.api.Assertions.assertThat;

public class OperatorFactoryTest {
    private OperatorFactory factory = new OperatorFactory();

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void should_return_an_Identity_operator() {
        assertThat(factory.parseToOperator("1")).isExactlyInstanceOf(Identity.class);
    }

    @Test
    public void should_return_an_addition() {
        assertThat(factory.parseToOperator("1+2")).isExactlyInstanceOf(Addition.class);
    }

    @Test
    public void should_return_a_multiplication() {
        assertThat(factory.parseToOperator("2*5")).isExactlyInstanceOf(Multiplication.class);
    }

    @Test
    public void should_return_a_subtraction() {
        assertThat(factory.parseToOperator("2-5")).isExactlyInstanceOf(Subtraction.class);
    }

    @Test
    public void should_raise_unsupported_operation_exception() {
        thrown.expect(UnsupportedOperationException.class);
        thrown.expectMessage("unsupported operation: 1;2");
        factory.parseToOperator("1;2");
    }
}
