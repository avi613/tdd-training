package avi.edu.calculator.operator;

public class Identity implements Operator {
    @Override
    public int operate(int[] numbers) {
        return numbers == null ? 0 : numbers[0];
    }
}
