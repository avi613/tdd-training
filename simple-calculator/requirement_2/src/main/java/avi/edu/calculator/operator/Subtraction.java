package avi.edu.calculator.operator;

import static java.util.Arrays.stream;

public class Subtraction implements Operator {
    @Override
    public int operate(int[] numbers) {
        return numbers == null ? 0 : stream(numbers).reduce(0, (a, b) -> a == 0 ? b : a - b);
    }
}
