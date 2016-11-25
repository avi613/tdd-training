package avi.edu.calculator.operation;

import avi.edu.calculator.operator.Addition;
import org.junit.Test;

import static org.mockito.Mockito.*;

public class OperationTest {
    @Test
    public void should_invoke_an_addition() {
        // given
        int[] operands = new int[]{1, 2};
        Addition addition = mock(Addition.class);
        Operation operation = new Operation(operands, addition);

        // when
        operation.operate();

        // then
        verify(addition, times(1)).operate(operands);
    }
}
