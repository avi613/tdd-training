package avi.edu.calculator.operation;

import avi.edu.calculator.operator.Addition;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class OperationTest {
    @Test
    public void should_add_two_numbers() {
        Operation operation = new Operation(new int[] {1, 2}, new Addition());
        assertThat(operation.operate()).isEqualTo(3);
    }
}
