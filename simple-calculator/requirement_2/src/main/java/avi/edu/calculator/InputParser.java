package avi.edu.calculator;

import avi.edu.calculator.operation.Operation;
import avi.edu.calculator.operator.*;

import static java.util.Arrays.stream;

public class InputParser {
    private final String regex = "\\+|\\*|-";

    private OperatorFactory factory;

    public InputParser(OperatorFactory factory) {
        this.factory = factory;
    }

    public Operation parseToOperation(String input) {
        if(numberOfOperandsGreaterThanTwo(input)) throw new IllegalArgumentException("Cannot process more than 2 numbers");
        return input.trim().isEmpty()
                ? zero()
                : operandsArray(input);
    }

    private boolean numberOfOperandsGreaterThanTwo(String input) {
        return input.split(regex).length > 2;
    }

    private Operation zero() {
        return new Operation(new int[]{0}, new Identity());
    }

    private Operation operandsArray(String input) {
        return new Operation(
                stream(input.split(regex)).map(String::trim).mapToInt(Integer::parseInt).toArray(),
                factory.parseToOperator(input));
    }
}
