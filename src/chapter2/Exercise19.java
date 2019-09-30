package chapter2;

import java.util.Scanner;

public class Exercise19 {
    public static void main(String[] args) {
        double[] points = new double[6];
        double[] sides = new double[3];
        Scanner input = new Scanner(System.in);

        System.out.print("Enter the coordinates of three points separated by spaces: ");
        String[] s = input.nextLine().split(" ");
        for (int i = 0; i < 6; i++) {
            try {
                points[i] = Double.parseDouble(s[i]);
            } catch (NumberFormatException e) {
                System.out.println("Incorrect numbers entered. Exiting");
                System.exit(1);
            }
        }

        sides[0] = dist(points[0], points[1], points[2], points[3]);
        sides[1] = dist(points[2], points[3], points[4], points[5]);
        sides[2] = dist(points[4], points[5], points[0], points[1]);
        double res1 = (sides[0] + sides[1] + sides[2]) / 2;
        double area = Math.sqrt(res1 * (res1 - sides[0]) * (res1 - sides[1]) * (res1 - sides[2]));

        System.out.printf("The area of the triangle is %.1f", area);
    }

    private static double dist(double x1, double y1, double x2, double y2) {
        y2 -= y1;
        x2 -= x1;
        return Math.sqrt(y2 * y2 + x2 * x2);
    }
}
