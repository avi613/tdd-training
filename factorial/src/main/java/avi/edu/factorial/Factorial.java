package avi.edu.factorial;

public class Factorial {
    public Trampoline<Integer> of(final int initialNumber, int result) {
        return initialNumber == 1 ? new Trampoline<Integer>() {
            public Integer get() {
                return result;
            }
        } : new Trampoline<Integer>() {
            public Trampoline<Integer> run() {
                System.out.println("current number: " + initialNumber + ", current result: " + result);
                return of(initialNumber - 1, result * initialNumber);
            }
        };
    }

    public static void main(String[] args) {
        Factorial factorial = new Factorial();
        System.out.println("final result: " + factorial.of(12, 1).execute());
    }
}
