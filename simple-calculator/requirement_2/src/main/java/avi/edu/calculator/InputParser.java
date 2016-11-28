package avi.edu.calculator;

import avi.edu.calculator.operation.Operation;
import avi.edu.calculator.operator.*;

import static java.util.Arrays.stream;

public class InputParser {
    private final String allowedOperators = "\\+|\\*|-";
    private OperatorFactory factory;

    public InputParser(OperatorFactory factory) {
        this.factory = factory;
    }

    public Operation parseToOperation(String input) {
        if (numberOfOperandsGreaterThanTwo(input))
            throw new IllegalArgumentException("Cannot process more than 2 numbers");

        return isInputBlankOrEmpty(input)
                ? zero()
                : operandsArray(input);
    }

    private boolean numberOfOperandsGreaterThanTwo(String input) {
        return input.split(allowedOperators).length > 2;
    }

    private boolean isInputBlankOrEmpty(String input) {
        return input.trim().isEmpty();
    }

    private Operation zero() {
        return new Operation(new int[]{0}, new Identity());
    }

    private Operation operandsArray(String input) {
        Operator operator = factory.parseToOperator(input);
        int[] operands = stream(input.split(allowedOperators))
                .map(String::trim)
                .mapToInt(Integer::parseInt)
                .toArray();

        return new Operation(operands, operator);
    }
}
