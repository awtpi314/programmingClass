package chapter9;

import java.util.Scanner;

/**
 * <h1>Exercise10</h1>
 * <p>Exercise 9.10 calculates the roots of a quadratic equation that the user inputs from the command line</p>
 * <br/>
 * <p>Alexander Taylor</p>
 * <p>Thursday, March 5, 2020</p>
 * <p>TPS Java 2019-2020</p>
 * <p>Mr. Yonts</p>
 */
public class Exercise10 {

    public static void main(String[] args) {
        // The Scanner used to get input from the user
        Scanner input = new Scanner(System.in);
        // The String array of the input from the user
        String[] inLine = input.nextLine().split(" ");
        // Close the Scanner to prevent resource leaks
        input.close();
        // The array that will be used to store the constants for the equation
        double[] constants = new double[3];

        // Make sure that we have enough constants
        if (inLine.length < 3) {
            error("Error: only " + inLine.length + " doubles were entered. Exiting...");
        }

        // Validate and store the input
        for (int i = 0; i < 3; i++) {
            try {
                constants[i] = Double.parseDouble(inLine[i]);
            } catch (NumberFormatException e) {
                error("Argument #" + i + " is not a double. Exiting...");
            }
        }

        // Make a new QuadraticEquation
        QuadraticEquation equation = new QuadraticEquation(constants[0], constants[1], constants[2]);
        // Get the root
        double root1 = equation.getRoot1();
        // Check what type of equation it is
        if (Double.isNaN(root1)) {
            System.out.println("The equation has no real roots.");
        } else if (equation.getDiscriminant() == 0) {
            System.out.println("The equation has one root " + root1);
        } else {
            System.out.println("The equation has two roots " + root1 + " and " + equation.getRoot2());
        }
    }

    /**
     * Prints an error to the standard error
     *
     * @param message the message to print
     */
    private static void error(String message) {
        System.err.println(message);
        System.exit(1);
    }
}

/**
 * <h1>QuadraticEquation</h1>
 * <p>This class stores a quadratic equation and calculates various things about it.</p>
 */
class QuadraticEquation {
    /**
     * This constant is one of the constants that are used in the quadratic equation.
     */
    private final double a, b, c;

    /**
     * The constructor for the QuadraticEquation
     *
     * @param a constant term a
     * @param b constant term b
     * @param c constant term c
     */
    public QuadraticEquation(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
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

    /**
     * Gets the discriminant of the equation
     *
     * @return the discriminant of the equation
     */
    public double getDiscriminant() {
        return (this.b * this.b) - 4 * this.a * this.c;
    }

    /**
     * Gets the first root of the equation
     *
     * @return the positive root of the equation
     */
    public double getRoot1() {
        return this.getSolution(1);
    }

    /**
     * Gets the second root of the equation
     *
     * @return the negative root of the equation
     */
    public double getRoot2() {
        return this.getSolution(-1);
    }

    /**
     * A private helper method to get the solution for a specified sign
     *
     * @param sign the sign of the root
     * @return the solution
     */
    private double getSolution(double sign) {
        double discriminant = this.getDiscriminant();

        if (discriminant < 0) {
            return Double.NaN;
        }

        return ((-this.b) + (Math.sqrt(discriminant) * (sign / Math.abs(sign)))) / (2 * this.a);
    }
}