package chapter8;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Exercise5 {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        double[][] inputMatrixA = getMatrix(keyboard, 3, 3, "matrix1");
        double[][] inputMatrixB = getMatrix(keyboard, 3, 3, "matrix2");
        keyboard.close();

        System.out.println("The matrices are added as follows:");
        printMatrix(inputMatrixA);
        System.out.println("\t\t+");
        printMatrix(inputMatrixB);
        System.out.println("\t\t=");
        printMatrix(addMatrix(inputMatrixA, inputMatrixB));
    }

    public static double[][] getMatrix(Scanner input, int matrixHeight, int matrixWidth, String matrixName) {
        System.out.print("Enter " + matrixName + ": ");
        double[][] inputMatrix = new double[matrixWidth][matrixHeight];
        for (int j = 0; j < matrixHeight; j++) {
            for (int i = 0; i < matrixWidth; i++) {
                String inString = input.next();
                try {
                    inputMatrix[j][i] = Double.parseDouble(inString);
                } catch (NumberFormatException e) {
                    System.err.println(inString + " is not a double. Ignoring this value.");
                }
            }
        }
        return inputMatrix;
    }

    public static double[][] addMatrix(double[][] a, double[][] b) {
        if (a.length != b.length || a[0].length != b[0].length) {
            throw new InputMismatchException("Matrix sizes need to be the same.");
        }

        double[][] c = new double[a.length][a[0].length];
        for (int i = 0; i < c.length; i++) {
            for (int j = 0; j < c[0].length; j++) {
                c[i][j] = a[i][j] + b[i][j];
            }
        }

        return c;
    }

    public static void printMatrix(double[][] outMatrix) {
        for (double[] currArr : outMatrix) {
            for (double current : currArr) {
                System.out.print(current + " ");
            }
            System.out.println();
        }
    }
}
