package avi.edu.calculator.operator;

import com.google.common.collect.ImmutableMap;

import java.util.Map;
import java.util.function.Supplier;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class OperatorFactory {
    private Map<String, Supplier<Operator>> operators = ImmutableMap.of(
            "+", Addition::new, "*", Multiplication::new, "-", Subtraction::new, "", Identity::new
    );

    public Operator parseToOperator(String input) {
        return operators.get(extractOperator(input)).get();
    }

    private String extractOperator(String input) {
        Matcher matcher = Pattern.compile("\\+|\\*|-").matcher(input);
        return matcher.find() ? matcher.group() : "";
    }
}
