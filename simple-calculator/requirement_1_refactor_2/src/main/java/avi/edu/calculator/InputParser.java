package avi.edu.calculator;

import avi.edu.calculator.operation.Operation;
import avi.edu.calculator.operator.Addition;

import static java.util.Arrays.stream;

public class InputParser {
    public Operation parseToOperation(String input) {
        if (input.split(",").length > 2)
            throw new IllegalArgumentException("Number of operands cannot be greater than 2");
        return new Operation(
                input.trim().isEmpty()
                        ? new int[]{0}
                        : stream(input.split(",")).map(String::trim).mapToInt(Integer::parseInt).toArray(),
                new Addition()
        );
    }
}
