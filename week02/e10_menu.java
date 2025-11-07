/**
 * A program to choose menu and perform calculation based on options provided; 
 * if user choose an incorrection option, program still keep asking to re-input a correct option number
 */
package week02;

import java.util.Scanner;
import java.time.LocalTime;

public class e10_menu {
    static float[] callInput(Scanner scan) {
        float num[] = new float[2];
        System.out.print("\nFirst number: ");
        num[0] = scan.nextFloat();
        System.out.print("Second number: ");
        num[1] = scan.nextFloat();
        return num;
    }

    static void add(float n1, float n2) {
        System.out.printf("[+] Addition\n%02.2f + %02.2f = %02.2f", n1, n2, n1 + n2);
    }

    static void abs(float n1, float n2) {
        System.out.printf("[-] Substraction\n%02.2f - %02.2f = %02.2f", n1, n2, n1 - n2);
    }

    static void mul(float n1, float n2) {
        System.out.printf("[x] Multiplication\n%02.2f x %02.2f = %02.2f", n1, n2, n1 * n2);
    }

    static void div(float n1, float n2) {
        System.out.printf("[/] Division\n%02.2f / %02.2f = %02.2f", n1, n2, n1 / n2);
    }

    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            int pick; // menu state
            float[] num = new float[2]; // calculation variables
            out: while (true) {
                System.out.println("\n\n== Math Menu ==");
                System.out.println("1. Addition (+)\n2. Substraction (-)\n" +
                        "3. Multiplication (x)\n4. Division (/)\n5. Quit\n");
                System.out.print("Please choose an option: ");
                pick = in.nextInt();

                switch (pick) {
                    case 1:
                        num = callInput(in);
                        add(num[0], num[1]);
                        break;
                    case 2:
                        num = callInput(in);
                        abs(num[0], num[1]);
                        break;
                    case 3:
                        num = callInput(in);
                        mul(num[0], num[1]);
                        break;
                    case 4:
                        num = callInput(in);
                        div(num[0], num[1]);
                        break;
                    case 5:
                        break out;

                    default:
                        System.out.println("[!] Please pick the choice given.");
                        try {
                            Thread.sleep(2000);
                        } catch (Exception e) {
                            System.out.println("[!] Interrupted!");
                        }
                        System.out.println("\033[H\033[2J");
                        break;
                }
            }
            System.out.println("Good bye! It's " + LocalTime.now().toString().substring(0, 8));

        } catch (Exception e) {
            System.out.println("\n[!] " + e.getClass().getSimpleName());
        }
    }
}
