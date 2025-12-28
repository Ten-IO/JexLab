/**
 * Program to create a class "GeometryArea" and inherit from following "Abstract ShapeArea"
 */
package week07;

import java.util.Scanner;
import java.util.function.Function;

public class e01_GeometryArea extends e01_AbstractShapeArea {
    static Scanner scan = new Scanner(System.in);

    static double input(String prompt) {
        System.out.print(prompt);
        return scan.nextDouble();
    }

    public static void main(String[] args) {
        e01_AbstractShapeArea geo = new e01_GeometryArea();
        int choice = 0;

        do {
            System.out.println(
                    "\n=== Menu ===\n1. Rectangle\n2. Circle\n3. Triangle (3 sides)\n4. Triangle (base and height)\n5. Semi-Circle\n6. Sector\n7. Quit");
            Function<Integer, String> calculateShape = in -> switch (in) {
                case 1 -> "Result: " + geo.calculateRectangleArea(input("Width: "), input("Height: "));
                case 2 -> "Result: " + geo.calculateCircleArea(input("radius: "));
                case 3 -> "Result: " + geo.calculateTraingleArea(input("a: "), input("b: "), input("c: "));
                case 4 -> "Result: " + geo.calculateTraingleArea(input("Base: "), input("Height: "));
                case 5 -> "Result: " + geo.calculateSemicirleArea(input("Radius: "));
                case 6 -> "Result: " + geo.calculateSectorArea(input("Radius: "), input("Angle: "));
                case 7 -> "Bye!";
                default -> "Unknown choice";

            };
            choice = (int) input("Enter you choice: ");
            System.out.println(calculateShape.apply(choice));
        } while (choice != 7);
    }

    @Override
    double calculateRectangleArea(double width, double height) {
        return width * height;
    }

    @Override
    double calculateCircleArea(double radius) {
        return 3.14 * radius * radius;
    }

    @Override
    double calculateTraingleArea(double a, double b, double c) {
        double S = (a + b + c) / 2;
        return Math.sqrt(S * (S - a) * (S - b) * (S - c));
    }

    @Override
    double calculateTraingleArea(double base, double height) {
        return base * height / 2;
    }

    @Override
    double calculateSemicirleArea(double radius) {
        return calculateCircleArea(radius) / 2;
    }

    @Override
    double calculateSectorArea(double radius, double angle) {
        return angle / 360 * calculateCircleArea(radius);
    }
}
