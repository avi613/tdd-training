package avi.edu.calculator;

import static java.util.Arrays.stream;

public class InputParser {
    public int[] parseToOperation(String input) {
        if (input.split(",").length > 2) throw new IllegalArgumentException("Cannot process more than 2 numbers");
        return input.trim().isEmpty() ? new int[] {0} : stream(input.split(",")).mapToInt(Integer::parseInt).toArray();
    }
}
