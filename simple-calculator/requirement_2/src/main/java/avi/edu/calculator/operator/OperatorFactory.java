package avi.edu.calculator.operator;

import com.google.common.collect.ImmutableMap;

import java.util.Map;
import java.util.function.Supplier;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class OperatorFactory {
    private final String supportedOperatorsRegex = "\\+|\\*|-";
    private Map<String, Supplier<Operator>> supportedOperators = ImmutableMap.of(
            "+", Addition::new, "*", Multiplication::new, "-", Subtraction::new, "ID", Identity::new
    );

    public Operator parseToOperator(String input) {
        return supportedOperators.get(extractOperator(input)).get();
    }

    private String extractOperator(String input) {
        Matcher matcher = Pattern.compile(supportedOperatorsRegex).matcher(input);

        if (matcher.find()) return matcher.group();
        if (input.matches("\\d+")) return "ID";

        throw new UnsupportedOperationException("unsupported operation: " + input);
    }
}
