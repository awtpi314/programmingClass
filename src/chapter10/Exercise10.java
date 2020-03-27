package chapter10;

import java.util.Arrays;

/**
 * Exercise 10.10
 * <br/>
 * Alexander Taylor
 * <br/>
 * Wednesday, March 25, 2020
 */
public class Exercise10 {
    public static void main(String[] args) {
        // Create a new queue
        Queue q = new Queue();
        // Add all the elements to the queue
        for (int i = 0; i < 20; i++) {
            q.enqueue(i + 1);
        }

        // Print all the elements in the queue
        System.out.print("Numbers removed from queue: ");
        for (int i = 0; i < q.getSize(); i++) {
            System.out.printf("%d ", q.dequeue());
        }
    }
}

/**
 * Queue
 * <br/>
 * This class uses an array to implement a queue
 */
class Queue {
    // The array that will hold the items in the queue
    private int[] elements;
    // How many elements are in the queue
    private int size;

    /**
     * Default constructor
     * <br/>
     * This constructor initializes the queue with an initial array size of 8
     */
    public Queue() {
        elements = new int[8];
        size = 0;
    }

    /**
     * Add an element to the end of the queue
     *
     * @param n the item to add to the queue
     */
    public void enqueue(int n) {
        // Check if we need to enlarge the queue
        if (size >= elements.length - 1) {
            elements = Arrays.copyOf(elements, elements.length * 2);
        }
        // Assign the item to the correct position
        elements[size] = n;
        // Increment the size of the queue
        size++;
    }

    /**
     * Remove and return the first element in the queue
     *
     * @return the first element in the queue
     */
    public int dequeue() {
        // Check that there is at least one element
        if (size <= 0) throw new ElementUnavailableException();

        // Get the element to return
        int returnElement = elements[0];

        // Move all the elements over one position
        System.arraycopy(elements, 1, elements, 0, size - 1);

        // Return the removed element
        return returnElement;
    }

    /**
     * Check to see if the queue is empty
     *
     * @return if the queue is empty or not
     */
    public boolean empty() {
        return size == 0;
    }

    /**
     * Get the size of the queue
     *
     * @return the size of the queue
     */
    public int getSize() {
        return size;
    }


    /**
     * Custom exception type for this class
     */
    public static class ElementUnavailableException extends RuntimeException {
    }
}
