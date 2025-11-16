/**
 *  Write a program using Function to find roots of quadratic equation  ax^2+ bx +c=0  when “a”, “b” and “c” are 
 *  given by user input
 */
package week03;
import java.util.Scanner;

public class e01_quadEquation {

    static float[] solveQuad(float a, float b, float c) {
        if (a == 0) {
            if (b != 0)
                return new float[] { -c / b };
            throw new IllegalArgumentException("Infinity");

        } else {
            float disc = b * b - 4 * a * c;
            float delta = (float) Math.sqrt(disc);
            if (disc > 0)
                return new float[] { (-b - delta) / (2 * a), (-b + delta) / (2 * a) };
            else if (disc == 0)
                return new float[] { -b / (2 * a) };
            else
                throw new IllegalArgumentException("Discriminant < 0; no real roots");
        }
    }

    static Scanner scan = new Scanner(System.in);

    static float input(String prompt) {
        float val = 0;
        try {
            System.out.print(prompt);
            val = scan.nextFloat();
        } catch (Exception e) {
            System.out.println("[!] Error: " + e.getClass().getSimpleName());
        }
        return val;
    }

    public static void main(String[] args) {
        System.out.println("[ Quadratic Solver ax\u00B2 + bx + c = 0 ]");
        float a = input("Input value of a: "), b = input("Input value of b: "), c = input("Input value of c: ");
        try {
            float[] roots = solveQuad(a, b, c);
            for (float r : roots) {
                System.out.printf("X = %.2f ", r);
            }
        } catch (Exception e) {
            System.out.println("[!] Fault: " + e.getMessage());
        }
    }
}