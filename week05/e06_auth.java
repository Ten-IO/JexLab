/*
    program to manage authentication of a system.
    → User data must be permanently stored in local files  (Ex. user.txt)
 */
package week05;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class e06_auth {
    static Scanner scan = new Scanner(System.in);
    static Path userPath = Paths.get("user.txt");

    static int askInt(String prompt) {
        System.out.print(prompt + " ");
        int res = scan.nextInt();
        scan.nextLine();
        return res;
    }

    static String askStr(String prompt) {
        System.out.print(prompt + " ");
        return scan.nextLine();
    }

    static void ensureFile() {
        try {
            if (!Files.exists(userPath)) Files.createFile(userPath);
        } catch (IOException e) {
            System.out.println("[!] Error creating user file.");
        }
    }

    static List<String> readUsers() {
        ensureFile();
        try {
            return Files.readAllLines(userPath);
        } catch (IOException e) {
            System.out.println("[!] Error reading user file.");
            return new ArrayList<>();
        }
    }

    static void appendUser(String line) {
        ensureFile();
        try {
            Files.write(userPath, Arrays.asList(line), StandardOpenOption.APPEND);
        } catch (IOException e) {
            System.out.println("[!] Error writing user file.");
        }
    }

    static void login() {
        List<String> users = readUsers();

        System.out.println("==== Login ====");
        String login = askStr("Email or Username:");
        String pass  = askStr("Password:");

        boolean found = false;
        for (String u : users) {
            // FirstName|LastName|Username|Email|Password
            String[] p = u.split("\\|");
            if (p.length >= 5) {
                String fname = p[0];
                String lname = p[1];
                String username = p[2];
                String email = p[3];
                String password = p[4];

                if ((username.equalsIgnoreCase(login) || email.equalsIgnoreCase(login))
                        && password.equals(pass)) {
                    System.out.println("=========== User Info ===========");
                    System.out.println("Hi " + fname + " " + lname + ",");
                    System.out.println("Your username is: " + username);
                    System.out.println("Your email is: " + email);
                    found = true;
                    break;
                }
            }
        }

        if (!found) {
            System.out.println("User not found. Please try again");
        }
    }

    static void registerUser() {
        System.out.println("==== Register a new user ====");
        String fname = askStr("First Name:");
        String lname = askStr("Last Name:");
        String username = askStr("Username:");
        String email = askStr("Email:");
        String password = askStr("Password:");

        String line = String.join("|", fname, lname, username, email, password);
        appendUser(line);
        System.out.println("You are successfully registered~");
    }

    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("==== Menu ===");
            System.out.println("1. Login");
            System.out.println("2. Register");
            System.out.println("3. Quit");
            choice = askInt("Choose an option:");

            switch (choice) {
                case 1 -> login();
                case 2 -> registerUser();
                case 3 -> choice = -1;
                default -> System.out.println("Try pick 1-3");
            }
        } while (choice != -1);
    }
}
