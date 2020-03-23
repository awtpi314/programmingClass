package chapter10;

import java.awt.geom.Point2D;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * <p>Alexander Taylor</p>
 * <p>Sunday, March 22, 2020</p>
 * <p>Mr. Yonts</p>
 * <p>TPS Java 2019-2020</p>
 */
public class Exercise4 {
    public static void main(String[] args) {
        System.out.print("Enter two points (x1 y1 x2 y2): ");
        Scanner input = new Scanner(System.in);
        String[] rawInput = input.nextLine().split(" ");
        input.close();

        if (rawInput.length < 4) {
            throw new InputMismatchException(String.format("Expected four numbers, only got %d", rawInput.length));
        }

        double[] constants = new double[4];
        for (int i = 0; i < 4; i++) {
            try {
                constants[i] = Double.parseDouble(rawInput[i]);
            } catch (NumberFormatException e) {
                throw new NumberFormatException(String.format("Argument %d is not a double", i));
            }
        }

        MyPoint point1 = new MyPoint(constants[0], constants[1]);
        MyPoint point2 = new MyPoint(constants[2], constants[3]);
        System.out.println(String.format("The distance between the points is %f", point1.distance(point2)));
    }
}

class MyPoint {
    private final double x;
    private final double y;

    public MyPoint() {
        x = 0;
        y = 0;
    }

    public MyPoint(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double distance(MyPoint secondPoint) {
        return Point2D.distance(secondPoint.getX(), secondPoint.getY(), getX(), getY());
    }

    public double distance(double x, double y) {
        return Point2D.distance(x, y, getX(), getY());
    }
}
