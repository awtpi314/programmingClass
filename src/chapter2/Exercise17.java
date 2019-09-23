package chapter2;

import java.util.Scanner;

public class Exercise17 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        double temperature = -100;
        double windspeed = 0;
        boolean incorrect;

        System.out.print("Enter the temperature in Fahrenheit between -58° and 41°: ");

        do {
            if (input.hasNextDouble()) {
                temperature = input.nextDouble();
                incorrect = temperature > 41 || temperature < -58;
            } else {
                input.next();
                incorrect = true;
            }

            if (incorrect) {
                System.out.print("Invalid input. Enter the temperature in Fahrenheit between -58° and 41°: ");
            }
        } while (temperature > 41 || temperature < -58);

        System.out.print("Enter the wind speed (>=2) in miles per hour: ");

        do {
            if (input.hasNextDouble()) {
                windspeed = input.nextDouble();
                incorrect = windspeed < 2;
            } else {
                input.next();
                incorrect = true;
            }

            if (incorrect) {
                System.out.print("Invalid input. Enter the wind speed (>=2) in miles per hour: ");
            }
        } while (windspeed < 2);

        System.out.printf("The wind chill index is %.5f", 35.74 + 0.6215 * temperature - 35.75 *
                Math.pow(windspeed, 0.16) + 0.4275 * temperature * Math.pow(windspeed, 0.16));
    }
}
