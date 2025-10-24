/**
 * Program using to count number of Vowel, Consonant and Space
 */
package week02;

import java.util.Scanner;

public class e07_charCounter {
    static boolean checkVow(char c) {
        return (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u');
    }

    static int checkCon(String sentence) {
        int count = 0;
        for (char c : sentence.toLowerCase().toCharArray())
            if (checkVow(c))
                count++;
        return count;
    }

    static int checkVow(String sentence) {
        int count = 0;
        for (char c : sentence.toLowerCase().toCharArray())
            if (c > 96 && c < 123 && !checkVow(c))
                count++;
        return count;
    }

    static int checkSpace(String sentence) {
        int count = 0;
        for (char c : sentence.toCharArray())
            if (c == ' ') 
                count++;
        return count;
    }

    public static void main(String[] args) {
        try (Scanner scan = new Scanner(System.in)) {

            System.out.print("Input a sentence: ");
            String sen = scan.nextLine();
            System.out.printf("%n\tResult%nCount of vowel is: %02d%n", checkCon(sen));
            System.out.printf("Count of consonant is: %02d%n", checkVow(sen));
            System.out.printf("Count of space is: %02d%n", checkSpace(sen));
        } catch (Exception e) {
            System.out.println("[!] " + e.getClass().getSimpleName());
        }
    }
}
