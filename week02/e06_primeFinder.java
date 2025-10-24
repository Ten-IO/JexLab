/**
 *  Prime number is positive number greater than 2 and divisible only to its own and 1. 
 *  Implement an application Java that let user input a number then determine if it is a prime number
 */
package week02;

import java.util.Scanner;

public class e06_primeFinder {
    static boolean check(int n) {
        int min = (int) (Math.sqrt(n));
        System.out.println(min);
        for (int i = 2; i <= min; i++) {
            if (n % i == 0)
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            System.out.println("== Checking Prime ==");
            System.out.print("Your number: ");
            int i = in.nextInt();

            if (i <= 0)
                System.out.println("Prime are considered only positive numbers!");
            else if (check(i))
                System.out.println(i + " is a prime number");
            else
                System.out.println(i + " is not a prime number");
        } catch (Exception e) {
            System.out.println("[!] " + e.getClass().getSimpleName());
        }
    }
}
