package chapter8;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Exercise29 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int[][] m1 = getMatrix(input, 3, 3, "matrix 1");
        int[][] m2 = getMatrix(input, 3, 3, "matrix 2");
        input.close();

        System.out.print("The two arrays are ");
        if (!equals(m1, m2)) {
            System.out.print("not ");
        }
        System.out.println("identical.");
    }

    private static int[][] getMatrix(Scanner input, int matrixWidth, int matrixHeight, String matrixName) {
        System.out.print("Enter " + matrixName + ": ");
        int[][] inputMatrix = new int[matrixWidth][matrixHeight];
        for (int j = 0; j < matrixHeight; j++) {
            for (int i = 0; i < matrixWidth; i++) {
                String inString = input.next();
                // Validate data input
                try {
                    inputMatrix[j][i] = Integer.parseInt(inString);
                } catch (NumberFormatException e) {
                    System.err.println(inString + " is not a double. Ignoring this value.");
                }
            }
        }
        return inputMatrix;
    }

    private static Map<Integer, Integer> countOccurrences(int[][] matrix) {
        Map<Integer, Integer> occurrences = new HashMap<>();
        for (int[] row : matrix) {
            for (int column : row) {
                if (!occurrences.containsKey(column)) {
                    occurrences.put(column, 1);
                } else {
                    occurrences.put(column, occurrences.get(column) + 1);
                }
            }
        }
        return occurrences;
    }

    private static boolean equals(int[][] m1, int[][] m2) {
        return countOccurrences(m1).equals(countOccurrences(m2));
    }
}