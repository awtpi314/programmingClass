package chapter2;

import java.util.Scanner;

public class exercise14 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double pounds = -1;
        double inches = -1;
        double kilograms;
        double meters;

        System.out.print("Enter weight in pounds: ");
        if (sc.hasNextDouble()) {
            pounds = sc.nextDouble();
        }

        System.out.print("Enter height in inches: ");
        if (sc.hasNextDouble()) {
            inches = sc.nextDouble();
        }

        kilograms = pounds / 0.45359237;
        meters = inches / 0.0254;

        System.out.printf("BMI is %.4f", (kilograms / Math.pow(meters, 2)));
    }
}
