package chapter7;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * <h3>Exercise20_v2</h3>
 * <br>
 * <p>Exercise20_v2 is the second iteration of the exercise 7.20 in TPS Java</p>
 * <p>This iteration makes use of a custom class {@link SortableList} to store and sort numbers received from the command line.</p>
 * <br>
 * <p>Author: Alexander Taylor</p>
 * <p>Date: January 25, 2020</p>
 * <p>Teacher: Mr. Yonts</p>
 */
public class Exercise20_v2 {
    /**
     * <p>This variable stores the list of numbers used in both
     * {@link #getNSort(Scanner) getNSort} and {@link #print() print}<p/>
     */
    private SortableList numbers = new SortableList();

    public static void main(String[] args) {
        // Instantiate the main class
        Exercise20_v2 mainClass = new Exercise20_v2();
        // This Scanner will be passed into getNSort
        Scanner input = new Scanner(System.in);
        // Get and sort the numbers read in from the command line
        mainClass.getNSort(input);
        // Close the scanner to prevent memory leaks
        input.close();
        // Print the sorted list to standard out
        mainClass.print();
    }

    /**
     * <p>This method will get numbers from the command line and sort them using the sort method of SortableList</p>
     *
     * @param input is a scanner from which the method will read numbers.
     */
    public void getNSort(Scanner input) {
        // Check to make sure that a NullPointerException is not thrown
        if (input == null) {
            return;
        }
        System.out.print("Enter some doubles: ");
        // Store the input from the command line in a temporary string list
        List<String> stringInput = Arrays.asList(input.nextLine().split(" "));
        // Set up a lambda to run for each element in the stringInput array
        stringInput.forEach((String s) -> {
            // Do some input validation
            try {
                // Try to parse and assign the double from the current string
                this.numbers.add(Double.parseDouble(s));
            } catch (NumberFormatException e) {
                // Print an error to the standard error
                System.err.println(s + " is not a double. Ignoring this value.");
            }
        });

        // Sort the numbers using the built in selection sort method
        this.numbers.selectionSort();
    }

    /**
     * <p>This method prints the contents of the array to the standard out, each separated by a space</p>
     */
    public void print() {
        System.out.println("The sorted list is as follows:");
        // Set up a lambda to print the value followed by a space for each of the elements in the numbers list
        this.numbers.forEach((Double out) -> System.out.print(out + " "));
    }
}

/**
 * <h3>SortableList</h3>
 * <br>
 * <p>SortableList extends ArrayList<Double> and adds two of its own methods. It adds a public
 * {@link #selectionSort() selectionSort} method and a private helper method, {@link #swap(int, int) swap}</p>
 */
class SortableList extends ArrayList<Double> {
    /**
     * <p>This method uses the selection sort method to sort the array. Selection sort is a very simple sort that has efficiency of O(n^2)</p>
     */
    public void selectionSort() {
        // Store the length in a temporary int variable to eliminate a function call each iteration
        int length = this.size();

        // The outer loop goes through all the elements in the array
        for (int i = 0; i < length - 1; i++) {
            // The minimum index is assumed to be the smallest index of the un-sorted portion
            int minIndex = i;
            // The inner loop will loop through the un-sorted portion on the array
            for (int j = i + 1; j < length; j++) {
                // Check to see if the current item is less than that of the minimum
                if (this.get(j) < this.get(minIndex)) {
                    minIndex = j;
                }
            }

            // Make sure that the indices of the minimum and current values are not the same
            if (i != minIndex) {
                // Swap the smallest and the current values
                this.swap(minIndex, i);
            }
        }
    }

    /**
     * This method swaps the two elements at the two indices passed
     *
     * @param index1 the first index
     * @param index2 the second index
     */
    private void swap(int index1, int index2) {
        double temp = this.get(index1);
        this.set(index1, this.get(index2));
        this.set(index2, temp);
    }
}