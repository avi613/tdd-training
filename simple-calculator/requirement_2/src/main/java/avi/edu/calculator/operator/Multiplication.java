package avi.edu.calculator.operator;

import static java.util.Arrays.stream;

public class Multiplication implements Operator {
    @Override
    public int operate(int[] numbers) {
        return numbers == null ? 0 : stream(numbers).reduce(1, (a, b) -> a*b);
    }
}
