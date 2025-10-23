/**
 *  Convert money in Riels to Dollar. Suppose that conversion rate is 1$ = 4000៛.
 */
package week02;

import java.util.Scanner;

class e02_converter {
    public static void main(String[] args) {
        System.out.println("== Money Converter - Riels to Dollars ==");
        Scanner in = new Scanner(System.in);
        // Input
        System.out.print("Conversion rate: ");
        double i = in.nextDouble(), c;
        System.out.print("Amount to exhange in Riels: ");
        c = in.nextDouble();
        // Converter
        System.out.printf("%.0f RIELS -> %.2f USD", c, c / i);
        in.close();
    }
}