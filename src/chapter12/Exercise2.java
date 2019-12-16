package chapter12;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Exercise2 {
    public static void main(String[] args) {
        Integer[] ints = new Integer[2];
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < ints.length; i++) {
            Integer tempInt = null;
            while (tempInt == null) {
                System.out.print("Enter an integer: ");
                try {
                    tempInt = sc.nextInt();
                    ints[i] = tempInt;
                } catch (InputMismatchException e) {
                    System.out.printf("The value '%s' is not an integer.\n", sc.nextLine());
                }
            }
        }

        System.out.printf("The sum is %d\n", ints[0] + ints[1]);
    }
}
