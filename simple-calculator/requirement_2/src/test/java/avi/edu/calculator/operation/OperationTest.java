package avi.edu.calculator.operation;

import avi.edu.calculator.operator.Addition;
import avi.edu.calculator.operator.Identity;
import avi.edu.calculator.operator.Multiplication;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class OperationTest {
    @Test
    public void should_add_two_numbers() {
        assertThat(new Operation(new int[] {1, 2}, new Addition()).operate()).isEqualTo(3);
    }

    @Test
    public void should_multiply_two_numbers() {
        assertThat(new Operation(new int[] {2, 3}, new Multiplication()).operate()).isEqualTo(6);
    }

    @Test
    public void should_return_number_itself() {
        assertThat(new Operation(new int[] {5}, new Identity()).operate()).isEqualTo(5);
    }
}
