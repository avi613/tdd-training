package avi.edu.calculator.operator;

import static java.util.Arrays.stream;

public class Addition implements Operator {
    @Override
    public int operate(int[] numbers) {
        return stream(numbers).sum();
    }
}
