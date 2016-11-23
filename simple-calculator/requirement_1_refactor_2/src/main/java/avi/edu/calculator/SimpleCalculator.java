package avi.edu.calculator;

import lombok.Value;

@Value
public class SimpleCalculator {
    private InputParser inputParser;

    public int add(String numbers) {
        return inputParser.parseToOperation(numbers).operate();
    }

    public static void main(String[] args) {
        SimpleCalculator calculator = new SimpleCalculator(new InputParser());
        System.out.println("1 + 2 = " + calculator.add("1,2"));
        System.out.println("1 - 2 = " + calculator.add("1,-2"));
        System.out.println("45 = " + calculator.add("45"));
        System.out.println("no-input = " + calculator.add(""));
        System.out.println("blank-input = " + calculator.add("    "));
        try {
            System.out.print("bad-input = ");
            calculator.add("bad-input");
        }
        catch (Exception e) {
            System.out.println(e.toString());
        }
        try {
            System.out.print("1 + not-a-int = ");
            calculator.add("1,not-a-int");
        }
        catch (Exception e) {
            System.out.println(e.toString());
        }
        try {
            System.out.print("1 + 2 + 3 = ");
            calculator.add("1,2,3");
        }
        catch (Exception e) {
            System.out.println(e.toString());
        }
    }
}
