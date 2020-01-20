package chapter7;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * <h3>Exercise11</h3>
 * <p>Exercise11 is the week 18 Java lab from TPS Java</p>
 * <p>Alexander Taylor</p>
 * <p>Thursday, January 16, 2020</p>
 */
public class Exercise11 {
    /**
     * Compute the mathematical mean of the passed values array
     *
     * @param values a double array
     * @return the mathematical mean of the numbers in values
     */
    public static double mean(Double[] values) {
        // Make sure that we are not dividing by zero or trying to use a null array
        if (values != null && values.length > 0) {
            return sum(values) / values.length;
        } else {
            throw new UnexpectedArrayLength("Array length should be greater than zero");
        }
    }

    /**
     * Compute the sum of the passed double array
     *
     * @param values is the array of doubles to compute the sum
     * @return the sum of the values
     */
    private static double sum(Double[] values) {
        double total = 0;
        for (double current : values) {
            total += current;
        }
        return total;
    }

    /**
     * Compute the standard deviation of an array of numbers using the mean passed in
     *
     * @param values the array of values to calculate the standard deviation of
     * @param mean   the mean of the values calculated by {@link #mean}
     * @return the standard deviation of the array
     */
    public static double deviation(Double[] values, double mean) {
        double sum = 0;
        for (double value : values) {
            sum += Math.pow(value - mean, 2);
        }
        return Math.sqrt(sum / (values.length - 1));
    }

    /**
     * Gets values from the command line using the Scanner passed
     * @param sc A scanner reference
     * @return a double array that contains double values passed from the command line
     */
    public static Double[] getValues(Scanner sc) {
        String[] values = sc.nextLine().split(" ");
        List<Double> doubles = new ArrayList<>();
        for (String value : values) {
            try {
                doubles.add(Double.parseDouble(value));
            } catch (NumberFormatException e) {
                printError(value);
            }
        }
        return doubles.toArray(new Double[0]);
    }

    /**
     * Prints an error saying that the object a is not a double
     * @param a an object
     */
    public static void printError(Object a) {
        System.out.println(a + " is not a double. Ignoring this value...");
    }

    /**
     * The entry point of the program
     * @param args the command line args
     */
    public static void main(String[] args) {
        System.out.print("Enter ten values: ");
        Scanner input = new Scanner(System.in);
        Double[] values = getValues(input);
        input.close();
        double meanOfValues = mean(values);
        double deviation = deviation(values, meanOfValues);
        // I use printf here to specify the number of decimals that I want
        System.out.printf("The mean is %.5f\nThe standard deviation is %.5f", meanOfValues, deviation);
    }
}

/**
 * UnexpectedArrayLength is used for telling the user that the array entered is not of the correct length
 */
class UnexpectedArrayLength extends RuntimeException {
    public UnexpectedArrayLength(String s) {
        super(s);
    }
}