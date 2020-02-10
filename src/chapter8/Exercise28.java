package chapter8;

import java.util.Scanner;

/**
 * Exercise28
 * <p>
 * This Java lab tests to see if two arrays input by the user are strictly identical
 * <p>
 * Alexander Taylor
 * Wednesday, February 5, 2020
 * TPS Java 2019-2020
 * Mr. Yonts
 */
public class Exercise28 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int[][] matrix1 = getMatrix(input, 3, 3, "matrix1");
        int[][] matrix2 = getMatrix(input, 3, 3, "matrix2");
        input.close();

        System.out.print("The two arrays are ");
        if (!matrixEquals(matrix1, matrix2)) {
            System.out.print("not ");
        }
        System.out.print("strictly identical.");
    }

    /**
     * This method returns a matrix of size matrixWidth by matrixHeight
     *
     * @param input        the scanner that this method will use
     * @param matrixHeight the height of the input matrix
     * @param matrixWidth  the width of the input matrix
     * @param matrixName   the name of the matrix
     * @return the matrix that is input from the command line
     */
    public static int[][] getMatrix(Scanner input, int matrixHeight, int matrixWidth, String matrixName) {
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

    /**
     * This method checks whether m1 and m2 are strictly identical
     *
     * @param m1 matrix 1
     * @param m2 matrix 2
     * @return if the matrices are strictly identical or not
     */
    public static boolean matrixEquals(int[][] m1, int[][] m2) {
        if (m1.length != m2.length || m1[0].length != m2[0].length) {
            return false;
        }

        for (int i = 0; i < m1.length; i++) {
            for (int j = 0; j < m1[0].length; j++) {
                if (m1[i][j] != m2[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }
}
