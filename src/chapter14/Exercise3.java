package chapter14;

import java.util.Scanner;

public class Exercise3 {
    public static void main(String[] args) {
        Scanner stdin = new Scanner(System.in);
        System.out.print("Enter the first number: ");
        int firstNumber = stdin.nextInt();
        System.out.print("Enter the second number: ");
        int secondNumber = stdin.nextInt();
        stdin.close();

        System.out.printf("The GCD is %d", gcd(firstNumber, secondNumber));
    }

    public static int gcd(int m, int n) {
        if (m % n == 0) return n;
        else return gcd(n, m % n);
    }
}
