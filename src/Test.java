import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        System.out.print("Enter 10 double values: ");
        double[] array = new double[10];
        for (int i = 0; i < array.length; i++) {
            array[i] = keyboard.nextDouble();
        }
        keyboard.close();
        sort(array);
        System.out.println(java.util.Arrays.toString(array));
    }

    public static void sort(double[] v) {
        for (int i = v.length - 1; i > 0; i--) {
            for (int j = i - 1; j > -1; j--) {
                if (v[j] > v[i]) {
                    double t = v[j];
                    v[j] = v[i];
                    v[i] = t;
                }
            }
        }
    }
}
