package avi.edu.calculator.operator;

import static java.util.Arrays.stream;

public class Subtraction implements Operator {
    @Override
    public int operate(int[] operands) {
        return stream(operands).reduce(0, (a, b) -> a == 0 ? b : a - b);
    }
}
