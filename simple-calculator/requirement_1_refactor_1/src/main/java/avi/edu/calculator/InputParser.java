package avi.edu.calculator;

import static java.util.Arrays.stream;

public class InputParser {
    public int[] parse(String input) {
        if (input.trim().isEmpty())
            return new int[]{};
        if (input.split(",").length > 2)
            throw new IllegalArgumentException("Number of operands cannot be greater than 2");

        return stream(input.split(",")).map(String::trim).mapToInt(Integer::parseInt).toArray();
    }
}
