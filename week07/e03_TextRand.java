package week07;

import java.util.Random;
import java.util.Scanner;

public class e03_TextRand {
    abstract class TextRandomizer {
        abstract char randomizeACharacter();
        abstract String randomizeAString(int length);
        abstract String[] randomizeStrings(int length, int amount);
    }

    class e03_TextRandomizer extends TextRandomizer {
        String charSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        Random rand = new Random();

        @Override
        char randomizeACharacter() {
            int index = rand.nextInt(charSet.length());
            return charSet.charAt(index);
        }
        @Override
        String randomizeAString(int length) {
            String text = "";
            for (int i = 0; i < length; i++)
                text += randomizeACharacter() + " ";
            return text;
        }
        @Override
        String[] randomizeStrings(int length, int amount) {
            String arr[] = new String[amount];
            for (int i = 0; i < amount; i++)
                arr[i] = randomizeAString(length);
            return arr;
        }
    }
    static Scanner scan = new Scanner(System.in);

    static int input(String prompt) {
        System.out.print(prompt);
        return scan.nextInt();
    }
    public static void main(String[] args) {
        TextRandomizer rand = new e03_TextRand().new e03_TextRandomizer();
        int opt = 0;
        do {
            System.out.println("\n=== Text Randomizer ===");
            System.out.println("1. A Character\n2. A String\n3. Unique Strings");
            opt = input("Choose an opt: ");
            switch (opt) {
                case 1:
                    System.out.println(rand.randomizeACharacter());
                    break;
                case 2:
                    System.out.println(rand.randomizeAString((input("Length: "))));
                    break;
                case 3:
                    String[] res = rand.randomizeStrings(input("Length: "), input("Amount: "));
                    for (String t : res)
                        System.out.print(t + ' ');
                    break;
                case 4:
                    System.out.println("By1");
                    return;
                default:
                    break;
            }
        } while (opt != 4);
        scan.close();
    }
}
