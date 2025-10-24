/**
 * Implement an application Java that take a given number of seconds for converting into time with format
 * Format: Hours:Minutes:Seconds.
 */
package week02;

import java.util.Scanner;

public class e04_secondsToClock {
    public static void main(String args[]) {
        try (Scanner in = new Scanner(System.in)) {
            // User input
            System.out.print("Time in seconds: ");
            int sec = in.nextInt();

            // Converter
            System.out.println("In HH:MM:SS = "
                    + String.format("%02d", sec / 3600) + ":"
                    + String.format("%02d", sec % 3600 / 60) + ":"
                    + String.format("%02d", sec % 3600 % 60));
        } catch (Exception e) {
            System.out.println("[!] " + e.getClass().getSimpleName());
        }
    }
}