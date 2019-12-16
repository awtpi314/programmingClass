package classmates;

import java.util.Scanner;

class Wk12 {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        System.out.print("Enter the number of iterations: ");
        int number = keyboard.nextInt();
        keyboard.close();
        System.out.println("pi approximated in " + number + " steps is " + approxPi(number));
    }

    public static double approxPi(int iterations) {
        double pi = 0;
        for (int i = 1; i <= iterations; i++) {
            pi += (Math.pow(-1, (i + 1))) / ((2 * i) - 1);
        }
        pi *= 4;
        return pi;
    }
}
