/* Edgar D Rosales
   23 Aug 2024
   CSD420-J318 Advanced Java Programming
   Module 2.2 Assignment

   Create a program using a recursive method that returns the sum of the following type inputs.
    - m(i) = 1/2 + 2/3 + 3/4 + 4/5 + 5/6 … i/(i + 1)
    ‘m’ is to be replaced with the method name you use.
    Use three different input finishing values, testing your code to ensure it functions correctly.
    Examples: m(4), m(9), m(14).
 */

package org.example.csd420.Module02;

public class Module02 {
    // Recursive function to calculate the series m(i)
    public static double calculateSeries(int i) {
        // Base case
        if (i == 1) {
            System.out.print("1/2");
            return 0.5;
        }
        // recursive case
        double result = calculateSeries(i - 1);
        double term = (double) i / (i + 1);
        System.out.print(" + " + i + "/" + (i + 1));
        return result + term;
    }
    // Function to present the result
    public static void presenter(int i) {
        System.out.println("Calculating for m(" + i + "): ");
        double result = calculateSeries(i);
        System.out.print("\nThe Result of the series m(" + i + ") is: " + String.format("%.2f", result) + "\n");
    }
    // Main, just to set the cases to run through
    public static void main(String[] args) {
        int[] m = {5, 4, 9, 14};
        for (int i : m) {
            presenter(i);
        }
    }
}
