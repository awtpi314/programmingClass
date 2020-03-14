package chapter9;

import java.util.Scanner;

/**
 * <h1>Exercise11</h1>
 * <br/>
 * <p>Alexander Taylor</p>
 * <p>Friday, March 13, 2020</p>
 * <p>Mr. Yonts</p>
 * <p>TPS Java 2019-2020</p>
 */
public class Exercise11 {
    public static void main(String[] args) {
        // Prompt the user to enter some coefficients
        System.out.print("Enter the coefficients (a b c d e f): ");
        // Initialize the scanner
        Scanner input = new Scanner(System.in);
        // Get the input
        String[] coefficients = input.nextLine().split(" ");
        // Close the scanner to prevent resource leaks
        input.close();

        // Make sure we have the proper number of coefficients
        if (coefficients.length < 6) {
            new IllegalArgumentException("There should be six coefficients. Exiting").printStackTrace();
            System.exit(1);
        }

        // The array of double coefficients
        double[] dCoefficients = new double[6];
        // Convert the string coefficients into doubles
        for (int i = 0; i < 6; i++) {
            try {
                // Try to convert
                dCoefficients[i] = Double.parseDouble(coefficients[i]);
            } catch (NumberFormatException e) {
                // Print the error on failure
                e.printStackTrace();
                System.exit(1);
            }
        }

        // Initialize the equation
        LinearEquation equation = new LinearEquation(dCoefficients[0], dCoefficients[1], dCoefficients[2], dCoefficients[3], dCoefficients[4], dCoefficients[5]);

        // Check if the equation is solvable and print the results
        if (!equation.isSolvable()) {
            System.out.println("The equation has no solutions.");
        } else {
            System.out.printf("x is %.1f, y is %.1f", equation.getX(), equation.getY());
        }
    }
}

/**
 * <h1>LinearEquation</h1>
 * <br/>
 * <p>This class stores an instance of a system of linear equations and then solves them.</p>
 */
class LinearEquation {
    /**
     * The coefficients of the equation
     */
    private final double a, b, c, d, e, f;

    /**
     * Initializes the equation with the specified coefficients
     *
     * @param a coefficient a
     * @param b coefficient b
     * @param c coefficient c
     * @param d coefficient d
     * @param e coefficient e
     * @param f coefficient f
     */
    public LinearEquation(double a, double b, double c, double d, double e, double f) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        this.e = e;
        this.f = f;
    }

    /**
     * <p style="font-weight:bold;">isSolvable</p>
     *
     * @return whether the equation is solvable or not
     */
    public boolean isSolvable() {
        return a * d - b * c != 0;
    }

    /**
     * <p style="font-weight:bold;">getX</p>
     * <p>If the equation is not solvable, the method will return NaN</p>
     *
     * @return the x value that satisfies both equations
     */
    public double getX() {
        if (!isSolvable())
            return Double.NaN;
        return (e * d - b * f) / (a * d - b * c);
    }

    /**
     * <p style="font-weight:bold;">getY</p>
     * <p>If the equation is not solvable, the method will return NaN</p>
     *
     * @return the y value that satisfies both equations
     */
    public double getY() {
        if (!isSolvable())
            return Double.NaN;
        return (a * f - e * c) / (a * d - b * c);
    }

    public double getA() {
        return a;
    }

    public double getB() {
        return b;
    }

    public double getC() {
        return c;
    }

    public double getD() {
        return d;
    }

    public double getE() {
        return e;
    }

    public double getF() {
        return f;
    }
}
