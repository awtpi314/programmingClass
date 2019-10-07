package chapter3;

import java.util.Scanner;

public class Exercise1 {
    public static void main(String[] args) {
        double[] constants = new double[3];
        double[] answers = new double[2];
        double discriminant;
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a, b, c: ");
        String[] s = sc.nextLine().split(" ");
        sc.close();
        for (int i = 0; i < 3; i++) {
            try {
                constants[i] = Double.parseDouble(s[i]);
            } catch (NumberFormatException e) {
                System.out.println("Incorrect numbers entered. Exiting...");
                System.exit(1);
            }
        }

        discriminant = Math.sqrt(constants[1] * constants[1] - 4 * constants[0] * constants[2]);
        answers[0] = (-constants[1] + discriminant) / (2 * constants[0]);

        if (discriminant > 0) {
            answers[1] = (-constants[1] - discriminant) / (2 * constants[0]);
            System.out.printf("The equation has two roots: %f and %f\n", answers[0], answers[1]);
        } else if (discriminant == 0) {
            System.out.printf("The equation has one root: %f\n", answers[0]);
        } else {
            System.out.println("The equation has no real roots.");
        }
    }
}
