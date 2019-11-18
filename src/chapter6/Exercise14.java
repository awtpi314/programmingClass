package chapter6;

import java.util.Scanner;

public class Exercise14 {
    public static void main(String[] args) {
        double sum = 0;
        double currentFactor;

        System.out.print("Enter the number of iterations: ");
        int iters = (new Scanner(System.in)).nextInt();

        for (int i = 1; i < iters; i++) {
            currentFactor = 1.0 / (2 * i - 1);
            if (i % 2 == 0) {
                currentFactor *= -1;
            }
            sum += currentFactor;
        }

        double pi = sum * 4;
        System.out.println(pi);
    }
}
