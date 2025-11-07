/**
 * Program to find a maximum value among all values in an Array. Users can input values in Array as many as they want. 
 */
package week02;

import java.util.Scanner;

public class e09_max {
    public static void main(String[] args) {
        int curr = 0, i = 0, big = 0;
        try (Scanner scan = new Scanner(System.in)) {
            boolean yes = true;
            char c = '\0';
            do {
                // Accept value
                System.out.print("Input value in Array at index " + i + ": ");
                curr = scan.nextInt();

                // First assigned if index = 0
                big = i == 0 ? curr : big;
                if (curr > big)
                    big = curr;

                // Check Continue status
                while (true) {
                    System.out.print("Do you want to add more (y/n)?: ");
                    c = scan.next().toLowerCase().charAt(0);
                    if (c == 'y' || c == 'n') {
                        yes = c=='y' ? true : false; // or yes = ( c==y )
                        break;
                    } else
                        System.out.println("[!] Please put (y/n)");
                }
                i++;
            } while (yes);
            System.out.println("The biggest number among in Array is: " + big);
        } catch (Exception e) {
            System.out.println("\n[!] " + e.getClass().getSimpleName());
        }
    }
}