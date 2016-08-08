package avi.edu.calculator;

import avi.edu.calculator.operation.Operation;
import avi.edu.calculator.operator.*;

import static java.util.Arrays.stream;

public class InputParser {
    private final String regex = "\\+|\\*|-";

    protected Operator parseOperator(String input) {
        if (input.contains("+")) {
            return new Addition();
        }
        if (input.contains("*")) {
            return new Multiplication();
        }
        if (input.contains("-")) {
            return new Subtraction();
        }
        return new Identity();
    }

    protected boolean isNumberOfOperandsValid(String input) {
        return input.split(regex).length <= 2;
    }

    protected int[] parseOperands(String input) {
        if (isNumberOfOperandsValid(input)) {
            return stream(input.split(regex)).map(String::trim).mapToInt(Integer::parseInt).toArray();
        }
        throw new IllegalArgumentException("Number of operands cannot be greater than 2");
    }

    public Operation parse(String input) {
        return input.trim().isEmpty() ? new Operation(null, new Identity()) : new Operation(parseOperands(input), parseOperator(input));
    }
}
