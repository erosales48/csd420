package main.java;

public class ExceptionHandlingExample {
    public static void main(String[] args) {
        try {
            int[] numbers = {1, 2, 3};
            System.out.println(numbers[5]); // This will throw ArrayIndexOutOfBoundsException
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Array index is out of bounds! " + e.getMessage());
        } finally {
            System.out.println("This block is always executed.");
        }

        try {
            divide(10, 0);
        } catch (ArithmeticException e) {
            System.out.println("Cannot divide by zero! " + e.getMessage());
        }
    }

    public static void divide(int a, int b) throws ArithmeticException {
        if (b == 0) {
            throw new ArithmeticException("Division by zero is not allowed.");
        } else {
            System.out.println("Result: " + (a / b));
        }
    }
}
