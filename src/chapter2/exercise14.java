package chapter2;

import java.util.Scanner;

/**
 * exercise14
 * Alexander Taylor
 * TPS Java
 * Mr. Yonts
 *
 * This class calculates BMI based on height and weight
 * The user is prompted for weight in pounds and height
 * in inches. The class then converts the pounds and inches
 * to kilograms and meters. The BMI is then calculated and
 * output to the console.
 */
public class exercise14 {
    public static void main(String[] args) {
        // Declare the input scanner
        Scanner sc = new Scanner(System.in);

        // The variables used to store information
        // Initially set to -1 for use in input
        double pounds = -1;
        double inches = -1;
        double kilograms;
        double meters;

        // Prompt the user
        System.out.print("Enter weight in pounds: ");
        // Continue looping until a correct value is entered
        while (pounds <= 0) {
            // Get the next double from the scanner
            if (sc.hasNextDouble()) {
                pounds = sc.nextDouble();
            } else {
                // Clear the input stream so the next call doesn't fail
                sc.next();
                System.out.println("Invalid input. Enter weight in pounds: ");
            }
        }

        // Prompt the user
        System.out.print("Enter height in inches: ");
        // Continue looping until a correct value is entered
        while(inches <= 0) {
            // Get the next double from the scanner
            if (sc.hasNextDouble()) {
                inches = sc.nextDouble();
            } else {
                // Clear the input stream so the next call doesn't fail
                sc.next();
                System.out.println("Invalid input. Enter height in inches: ");
            }
        }

        // Convert the pounds to kilograms
        kilograms = pounds * 0.45359237;
        // Convert the inches to meters
        meters = inches * 0.0254;

        // Calculate and print the BMI
        System.out.printf("BMI is %.4f", (kilograms / Math.pow(meters, 2)));
    }
}
