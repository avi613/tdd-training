package avi.edu.calculator.operation;

import avi.edu.calculator.operator.Operator;
import lombok.Value;

@Value
public class Operation {
    private int[] operands;
    private Operator operator;
}
