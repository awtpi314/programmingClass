package chapter3;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.Scanner;

public class Exercise1 {
    public static void main(String[] args) {
        BigDecimal[] constants = new BigDecimal[3];
        BigDecimal[] answers = new BigDecimal[2];
        BigDecimal discriminant = new BigDecimal(0);
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a, b, c: ");
        String[] s = sc.nextLine().split(" ");
        sc.close();
        for (int i = 0; i < 3; i++) {
            try {
                constants[i] = new BigDecimal(Double.parseDouble(s[i]));
            } catch (NumberFormatException e) {
                System.out.println("Incorrect numbers entered. Exiting...");
                System.exit(1);
            }
        }

        try {
            discriminant = constants[1].multiply(constants[1]).subtract(constants[0].multiply(constants[2]).multiply(new BigDecimal(4))).sqrt(new MathContext(100));
        } catch (ArithmeticException e) {
            System.out.println("The equation has no real roots.");
            System.exit(1);
        }
        answers[0] = (constants[1].negate().add(discriminant)).divide(constants[0].multiply(new BigDecimal(2)), RoundingMode.HALF_UP);

        switch (discriminant.compareTo(new BigDecimal(0))) {
            case 1:
                answers[1] = (constants[1].negate().subtract(discriminant)).divide(constants[0].multiply(new BigDecimal(2)), RoundingMode.HALF_UP);
                System.out.printf("The equation has two roots: %f and %f\n", answers[0], answers[1]);
                break;
            case 0:
                System.out.printf("The equation has one root: %f\n", answers[0]);
                break;
        }
    }
}
