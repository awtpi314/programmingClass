package chapter7;

import java.util.Scanner;

public class Exercise3 {
    private int[] numbers = new int[100];

    public static void main(String[] args) {
        Exercise3 mainClass = new Exercise3();
        System.out.print("Enter some integers between 1 and 100: ");
        mainClass.getInts(new Scanner(System.in));
        mainClass.printValues();
    }

    private void clearArray() {
        for (int i = 0; i < this.numbers.length; i++) {
            numbers[i] = 0;
        }
    }

    public void getInts(Scanner scanner) {
        int inputInt = -1;
        do {
            if (scanner.hasNextInt()) {
                inputInt = scanner.nextInt();
                if (inputInt > 0 && inputInt <= 100) {
                    this.numbers[inputInt - 1]++;
                } else if (inputInt != 0) {
                    printError(inputInt);
                }
            } else {
                printError(scanner.next());
            }
        } while (inputInt != 0);
    }

    public void printValues() {
        for (int i = 0; i < this.numbers.length; i++) {
            if (this.numbers[i] > 0) {
                System.out.println((i + 1) + " occurs " + this.numbers[i] + " times.");
            }
        }
    }

    private void printError(Object value) {
        System.out.println(value + " is not an integer between 1 and 100. Ignoring this value.");
    }
}
