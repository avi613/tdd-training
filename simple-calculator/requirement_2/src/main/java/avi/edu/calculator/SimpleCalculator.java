package avi.edu.calculator;

import lombok.Value;

@Value
public class SimpleCalculator {
    private InputParser inputParser;

    public int operate(String numbers) {
        return inputParser.parse(numbers).operate();
    }

    public static void main(String[] args) {
        SimpleCalculator calculator = new SimpleCalculator(new InputParser());
        System.out.println("1 + 2 = " + calculator.operate("1+2"));
        System.out.println("1 - 2 = " + calculator.operate("1-2"));
        System.out.println("2 * 4 = " + calculator.operate("2*4"));
        System.out.println("45 = " + calculator.operate("45"));
        System.out.println("no-input = " + calculator.operate(""));
        System.out.println("blank-input = " + calculator.operate("    "));
        try {
            System.out.print("bad-input = ");
            calculator.operate("bad-input");
        }
        catch (Exception e) {
            System.out.println(e.toString());
        }
        try {
            System.out.print("1 + not-a-int = ");
            calculator.operate("1,not-a-int");
        }
        catch (Exception e) {
            System.out.println(e.toString());
        }
        try {
            System.out.print("1 + 2 + 3 = ");
            calculator.operate("1+2+3");
        }
        catch (Exception e) {
            System.out.println(e.toString());
        }
    }
}
