/**
 * Application Java that displays “Hello <input_name>!” where <input_name> 
 * represents user input from keyboard.
 */
package week02;

import java.util.Scanner;

public class e01_HelloInput {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Input your name: ");
        String i = in.nextLine();
        System.out.println("Hello " + i + '!');
        in.close();
    }
}