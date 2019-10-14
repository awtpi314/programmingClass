package chapter3;

import java.util.*;

/**
 * Alexander Taylor
 * October 10, 2019
 * Exercise8.java
 * Sorting Integers
 */

public class Exercise8 {
    public static void main(String[] args) {
        Scanner stdin = new Scanner(System.in);
        System.out.print("Enter three numbers separated by spaces: ");
        String[] inputs = stdin.nextLine().split(" ");
        stdin.close();
        List<Integer> numbers = new ArrayList<>();
        for (String input : inputs) {
            try {
                numbers.add(Integer.parseInt(input));
            } catch (NumberFormatException e) {
                System.out.println("One or more of the numbers is not in a valid format. Exiting...");
                System.exit(1);
            }
        }
        Collections.sort(numbers);
        for (Integer item : numbers) {
            System.out.print(item + " ");
        }
    }
}
