package chapter6;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.Scanner;

public class Exercise22 {
    final private static double EPSILON = Math.ulp(1.0);

    public static void main(String[] args) {
        // Get input from the user
        System.out.print("Enter a number: ");
        Scanner sc = new Scanner(System.in);
        double n = sc.nextDouble();
        // Close the scanner as to avoid memory leaks
        sc.close();

        // Run the square root methods
        System.out.printf("The approximate square root is: %f\n", sqrt(n));
        System.out.printf("The approximate square root using BigDecimal and 200 iterations is %s\n", sqrt(new BigDecimal(Double.toString(n)), 200).toPlainString());
        System.out.printf("The approximate square root using BigDecimal and 1000 iterations is %s", sqrt(new BigDecimal(Double.toString(n)), 1000).toPlainString());
    }

    // A compare double function that uses an epsilon
    private static boolean compareDouble(double a, double b) {
        return (Math.abs(a - b) < EPSILON);
    }

    // This method uses a double to approximate square roots
    private static double sqrt(double n) {
        // lastGuess and nextGuess cannot start out equal to each other
        double lastGuess = 0;
        double nextGuess = 1;

        // Loop while the lastGuess and nextGuess are not equal
        while (!compareDouble(lastGuess, nextGuess)) {
            lastGuess = nextGuess;
            nextGuess = (lastGuess + n / lastGuess) / 2;
        }

        return nextGuess;
    }

    // Just for fun, an alternate implementation using BigDecimal
    private static BigDecimal sqrt(BigDecimal n, int numIterations) {
        BigDecimal lastGuess = new BigDecimal("1.0");
        BigDecimal denominator = new BigDecimal("2.0");
        MathContext mc = new MathContext(numIterations + 10, RoundingMode.HALF_UP);

        for (int i = 0; i < numIterations; i++) {
            lastGuess = lastGuess.add(n.divide(lastGuess, mc)).divide(denominator, mc);
        }

        return lastGuess;
    }
}
