package chapter5;

import java.util.Scanner;

public class Exercise1 {
    public static void main(String[] args) {
        System.out.print("Enter integers. Input terminates at zero: ");

        Scanner sc = new Scanner(System.in);
        int inputInt;
        int total = 0;
        int numNeg = 0;
        int numPos = 0;
        do {
            inputInt = sc.nextInt();
            total += inputInt;
            if (inputInt != 0) {
                if (inputInt > 0) numPos++;
                else numNeg++;
            }
        } while (inputInt != 0);
        sc.close();

        System.out.println("The number of positives is " + numPos);
        System.out.println("The number of negatives is " + numNeg);
        System.out.println("The total is " + total);
        System.out.println("The average is " + (total / (double)(numNeg + numPos)));
    }
}
