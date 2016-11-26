package avi.edu.calculator.operator;

public class Identity implements Operator {
    @Override
    public int operate(int[] operands) {
        return operands[0];
    }
}
