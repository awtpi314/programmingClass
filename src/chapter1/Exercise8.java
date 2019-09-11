package chapter1;

public class Exercise8 {
    public static void main(String[] args) {
        double radius = 5.5;
        double perimeter = 2 * radius * Math.PI;
        double area = Math.pow(radius, 2) * Math.PI;
        System.out.printf("For a circle with radius of %.1f, the perimeter is %.4f, and the area is %.4f.\n", radius, perimeter, area);
    }
}
