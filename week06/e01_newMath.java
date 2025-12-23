/**
 * override all functions 
 * implement its own body statement to calculate accordingly
 */
package week06;

import java.util.Scanner;

public class e01_newMath {
    int reverseNumber(int number) {
        int reversed = 0;
        while (number != 0) {
            int digit = number % 10;
            reversed = reversed * 10 + digit;
            number /= 10;
        }
        return reversed;
    }

    int roundNumber(double number) {
        return number % 1 >= 0.5 ? (int) number + 1 : (int) number;
    }

    int countDistinct(int[] values) {
        if (values == null)
            return 0;
        int count = 0;
        for (int i = 0; i < values.length; i++) {
            boolean seen = false;
            for (int j = 0; j < i; j++)
                if (values[j] == values[i]) {
                    seen = true;
                    break;
                }
            if (!seen)
                count++;
        }
        return count;
    }

    int decimalToBinary(int decimal) {
        String bin = "";
        while (decimal > 0) {
            bin = (decimal % 2) + bin;
            decimal /= 2;
        }
        return Integer.parseInt(bin);
    }

    static int input(Scanner scan, String prompt) {
        System.out.print(prompt);
        return scan.nextInt();
    }

    static double Dinput(Scanner scan, String prompt) {
        System.out.print(prompt);
        return scan.nextDouble();
    }

    public static void main(String[] args) {
        e01_newMath math = new e01_newMath();
        int choice = 0;
        Scanner scan = new Scanner(System.in);
        do {
            System.out.println(
                    "\n=== Menu ===\n1. Reverse Number\n2. Round Number\n3. Count Distinct\n4. Decimal to Binary\n5. Exit");
            choice = input(scan, "Enter your choice: ");
            switch (choice) {
                case 1:
                    int num = input(scan, "::: Reverse a number :::\nInput number: ");
                    System.out.println("Output: " + math.reverseNumber(num));
                    break;
                case 2:
                    double d = Dinput(scan, "::: Round a number :::\nInput number: ");
                    System.out.println("Output: " + math.roundNumber(d));
                    break;
                case 3:
                    int[] arr = { 1, 2, 2, 3 };
                    System.out.println("::: Count Distinct Number :::\n" + java.util.Arrays.toString(arr));
                    System.out.println("Output: " + math.countDistinct(arr));
                    break;
                case 4:
                    int dec = input(scan, "::: Encode a number :::\nEnter a decimal number: ");
                    System.out.println("Output: " + math.decimalToBinary(dec));
                    break;
                default:
                    choice = 0;
            }
        } while (choice != -1);
    }
}