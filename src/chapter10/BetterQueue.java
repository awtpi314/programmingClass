package chapter10;

import java.util.LinkedList;

public class BetterQueue<T> {
    private final LinkedList<T> elements;

    public BetterQueue() {
        elements = new LinkedList<>();
    }

    public static void main(String[] args) {
        long start = System.nanoTime();
        BetterQueue<Integer> q = new BetterQueue<>();
        for (int i = 0; i < 200; i++) {
            q.enqueue(i + 1);
        }

        for (int i = 0; i < q.getSize(); i++) {
            q.dequeue();
        }
        long end = System.nanoTime();

        System.out.printf("\nTime taken: %f seconds.", (end - start) / 1000000000.0);
    }

    public void enqueue(T item) {
        elements.add(item);
    }

    public T dequeue() {
        return elements.removeFirst();
    }

    public boolean isEmpty() {
        return elements.size() == 0;
    }

    public int getSize() {
        return elements.size();
    }
}