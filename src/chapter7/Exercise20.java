package chapter7;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * <h3>Exercise20</h3>
 * <p>Exercise 7.20 requires a method to sort an array using selection sort.</p>
 */
public class Exercise20 {
    private static Double[] numbers;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        getNumbers(input);
        input.close();
        selectionSort();
        printArray();
    }

    public static void getNumbers(Scanner keyboard) {
        List<Double> inputList = new ArrayList<>();
        List<String> stringInput = Arrays.asList(keyboard.nextLine().split(" "));
        stringInput.forEach((String s) -> {
            try {
                inputList.add(Double.parseDouble(s));
            } catch (NumberFormatException e) {
                System.out.println(s + " is not a double. Ignoring this value.");
            }
        });
        numbers = inputList.toArray(new Double[0]);
    }

    public static void selectionSort() {
        int n = numbers.length;

        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (numbers[j] < numbers[minIndex]) {
                    minIndex = j;
                }
            }

            swap(minIndex, i);
        }
    }

    public static void swap(int index1, int index2) {
        double tmp = numbers[index1];
        numbers[index1] = numbers[index2];
        numbers[index2] = tmp;
    }

    public static void printArray() {
        for (Double output : numbers) {
            System.out.printf("%.2g ", output);
        }
    }
}