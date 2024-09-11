//Myelin Lennox, program to calculate info about a sphere
import java.util.Scanner;

public class SphereCalc {
    public static void main(String[] args) {
        // Declare scanner to get console input
        Scanner scanner = new Scanner(System.in);

        System.out.print("Sphere radius: ");

        // Use nextDouble to accept and read a double instead of a string
        double radius = scanner.nextDouble();

        // Declare varibles, use Math.PI for 3.141592653589793 from java.lang.Math
        double diameter = 2 * radius;
        double circumference = 2 * Math.PI * radius;
        double surfaceArea = 4 * Math.PI * radius * radius;
        double volume = (4.0 / 3.0) * Math.PI * Math.pow(radius, 3);

        // Print results of calculations
        System.out.println("Diameter: " + diameter);
        System.out.println("Circumference: " + circumference);
        System.out.println("Surface Area: " + surfaceArea);
        System.out.println("Volume: " + volume);

        scanner.close();
    }
}