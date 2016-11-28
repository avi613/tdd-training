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
import static org.mockito.Mockito.*;

public class SimpleCalculatorTest {
    private InputParser parser = mock(InputParser.class);
    private SimpleCalculator calculator = new SimpleCalculator(parser);

    @Test
    public void should_invoke_input_parser_parse_to_operation_method() {
        when(parser.parseToOperation(anyString())).thenReturn(new Operation(new int[]{36, 12}, new Addition()));
        calculator.operate("36+12");

        verify(parser, times(1)).parseToOperation("36+12");
    }
}
