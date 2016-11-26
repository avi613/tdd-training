package avi.edu.calculator.operator;

import static java.util.Arrays.stream;

public class Multiplication implements Operator {
    @Override
    public int operate(int[] operands) {
        return stream(operands).reduce(1, (a, b) -> a*b);
    }
}
