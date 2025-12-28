package week07;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.Collectors;

public class e02_NumberRand {
    static Scanner scan = new Scanner(System.in);

    abstract class NumberRandomizer {
        abstract int randomizeInBetween(int min, int max);

        abstract int[] randomizeUniqueBetween(int min, int max, int amount);
    }

    class _02Randomizer extends NumberRandomizer {
        @Override
        int randomizeInBetween(int min, int max) {
            return new Random().nextInt(max - min + 1) + min;
        }

        @Override
        int[] randomizeUniqueBetween(int min, int max, int amount) {
            return new Random().ints(min, max + 1).distinct().limit(amount).toArray();
        }
    }

    static int input(String prompt) {
        System.out.print(prompt);
        return scan.nextInt();
    }

    public static void main(String[] args) {
        NumberRandomizer nurand = new e02_NumberRand().new _02Randomizer();
        int choice = 0;
        do {
            Arrays.stream(
                    new String[] { "=== Number Randomizer ===", "1. In between", "2. Unique in between", "3. Quit" })
                    .forEach(System.out::println);
            try {
                choice = input("Enter a choice: ");
                switch (choice) {
                    case 1:
                        System.out.println("Result: " + nurand.randomizeInBetween(input("min: "), input("max: ")));
                        break;
                    case 2:
                        int[] res = nurand.randomizeUniqueBetween(input("min: "), input("max: "), input("amount: "));
                        System.out.println("Result: "
                                + Arrays.stream(res).mapToObj(String::valueOf).collect(Collectors.joining(" ")));
                        break;
                    case 3:
                        System.out.println("By1");
                        return;
                    default:
                        System.out.println("Case not found!");
                        break;
                }
            } catch (Exception e) {
                System.out.println("\nError: " + e.getMessage());
            }
        } while (choice != 3);
        scan.close();
    }
}