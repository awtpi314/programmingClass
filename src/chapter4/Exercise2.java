package chapter4;

import java.util.Scanner;

public class Exercise2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter point 1 (lat and long) in degrees: ");
        double lat1 = Math.toRadians(sc.nextDouble());
        double long1 = Math.toRadians(sc.nextDouble());
        System.out.print("Enter point 2 (lat and long) in degrees: ");
        double lat2 = Math.toRadians(sc.nextDouble());
        double long2 = Math.toRadians(sc.nextDouble());
        final double radius = 6371.01;
        double d = radius * Math.acos(Math.sin(lat1) * Math.sin(lat2) + Math.cos(lat1) * Math.cos(lat2) * Math.cos(long1 - long2));
        System.out.println("The distance between the two points is " + d + " km.");
    }
}
