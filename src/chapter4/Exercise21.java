package chapter4;

import java.util.Scanner;

public class Exercise21 {
    public static void main(String[] args) {
        System.out.print("Enter a SSN: ");
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        sc.close();
        String[] inDiv = input.split("-");
        if (inDiv[0].length() == 3 && inDiv[1].length() == 2 && inDiv[2].length() == 4) {
            System.out.println(input + " is a valid Social Security number.");
        } else {
            System.out.println(input + " is an invalid Social Security number.");
        }
    }
}
