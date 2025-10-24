/**
 * Program to find a minimum value among A, B, C, D and E
 */
package week02;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class e08_min {
    public static void main(String[] args) {
        Map<Character, Integer> data = new LinkedHashMap<>();
        char var[] = "ABCDEF".toCharArray();
        Character max[] = { null };
        Integer curr[] = { Integer.MAX_VALUE };
        try (Scanner in = new Scanner(System.in)) {

            System.out.println("== Minimum Value finder ==");
            for (char c : var) {
                System.out.print("Input " + c + ": ");
                data.put(c, in.nextInt());
            }
            // Map checker
            data.forEach((key, val) -> {
                if (val < curr[0]) {
                    curr[0] = val;
                    max[0] = key;
                }
            });
            System.out.println("[+] Current minimum is " + max[0] + " = " + curr[0]);
        } catch (Exception e) {
            System.out.println("[!] " + e.getClass().getSimpleName());
        }
    }
}
