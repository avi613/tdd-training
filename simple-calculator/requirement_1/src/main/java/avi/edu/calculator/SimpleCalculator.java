package avi.edu.calculator;

import static java.util.Arrays.stream;

public class SimpleCalculator {
    public int add(String numbers) {
        if (numbers.trim().split(",").length > 2) {
            throw new IllegalArgumentException("number of elements to add must not exceed 2");
        }
        if (numbers.trim().isEmpty())
            return 0;
        return stream(numbers.split(",")).map(String::trim).mapToInt(Integer::parseInt).sum();
    }

    public static void main(String[] args) {
        SimpleCalculator calculator = new SimpleCalculator();
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
