package avi.edu.calculator;

import avi.edu.calculator.operation.Operation;
import avi.edu.calculator.operator.Addition;

import static java.util.Arrays.stream;

public class InputParser {
    public Operation parseToOperation(String input) {
        if (numberOfOperandsIsGreaterThanTwo(input))
            throw new IllegalArgumentException("Cannot process more than 2 numbers");

        return new Operation(
                input.trim().isEmpty()
                        ? zeroArray()
                        : operandsArray(input),
                new Addition());
    }

    private boolean numberOfOperandsIsGreaterThanTwo(String input) {
        return input.split(",").length > 2;
    }

    private int[] zeroArray() {
        return new int[]{0};
    }

    private int[] operandsArray(String input) {
        return stream(input.split(",")).map(String::trim).mapToInt(Integer::parseInt).toArray();
    }
}
