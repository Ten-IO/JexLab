/**
 * Calculate value of x in a formula below: 
 * 1/x = 1/y + 1/z
 * Where y and z are given by user from keyboard. Suppose that x, y, z are non-zero.
 */
package week02;

import java.util.Scanner;

public class e05_equation {
    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {

            System.out.print("== Calculator for 1/x = 1/y + 1/z ==\nInput y: ");
            double y = in.nextDouble();
            System.out.print("Input z: ");
            double z = in.nextDouble();
            if (y == 0 || z == 0)
                System.out.println("[!] Values must be non-zero");
            else if (y + z == 0)
                System.out.println("[!] x cannot be zero. (y+z must not be zero)");
            else
                System.out.printf("Result = %.2f", y * z / (y + z));
        }catch(Exception e){
            System.out.println("[!] " + e.getClass().getSimpleName());
        }
    }
}
