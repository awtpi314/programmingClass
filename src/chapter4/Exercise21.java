package chapter4;

import java.util.Scanner;
import java.util.regex.Pattern;

public class Exercise21 {
    public static void main(String[] args) {
        System.out.print("Enter a SSN: ");
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        sc.close();
        if (Pattern.matches("[0-9]{3}-[0-9]{2}-[0-9]{4}", input)) {
            System.out.println(input + " is a Social Security number.");
        } else {
            System.out.println(input + " is not a Social Security number.");
        }
    }
}
