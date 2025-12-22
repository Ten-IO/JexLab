/*
    program to manage human resource of school
    → User data must be permanently stored in local file  (Ex. teacher.txt, student.txt, securityguard.txt)
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

public class e05_schoolResource {
    static Scanner scan = new Scanner(System.in);

    static Path teacherPath = Paths.get("teacher.txt");
    static Path studentPath = Paths.get("student.txt");
    static Path guardPath = Paths.get("securityguard.txt");

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

    static void ensureFile(Path p) {
        try {
            if (!Files.exists(p))
                Files.createFile(p);
        } catch (IOException e) {
            System.out.println("[!] Error creating file: " + p.getFileName());
        }
    }

    static List<String> readAll(Path p) {
        ensureFile(p);
        try {
            return Files.readAllLines(p);
        } catch (IOException e) {
            System.out.println("[!] Error reading " + p.getFileName());
            return new ArrayList<>();
        }
    }

    static void appendLine(Path p, String line) {
        ensureFile(p);
        try {
            Files.write(p, Arrays.asList(line), StandardOpenOption.APPEND);
        } catch (IOException e) {
            System.out.println("[!] Error writing " + p.getFileName());
        }
    }

    static void viewAll() {
        System.out.println("==== Teacher ====");
        List<String> teachers = readAll(teacherPath);
        int idx = 1;
        for (String t : teachers) {
            String[] p = t.split("\\|");
            if (p.length >= 6) {
                String fullName = p[0] + " " + p[1];
                System.out
                        .println(idx + ". [" + fullName + "][" + p[2] + "][" + p[3] + "][" + p[4] + "][" + p[5] + "$]");
                idx++;
            }
        }

        System.out.println("=========== Student ===========");
        List<String> students = readAll(studentPath);
        idx = 1;
        for (String s : students) {
            String[] p = s.split("\\|");
            if (p.length >= 6) {
                String fullName = p[0] + " " + p[1];
                System.out
                        .println(idx + ". [" + fullName + "][" + p[2] + "][" + p[3] + "][" + p[4] + "][" + p[5] + "]");
                idx++;
            }
        }
        System.out.println("=========== Security guard ===========");
        List<String> guards = readAll(guardPath);
        idx = 1;
        for (String g : guards) {
            String[] p = g.split("\\|");
            if (p.length >= 5) {
                String fullName = p[0] + " " + p[1];
                System.out.println(idx + ". [" + fullName + "][" + p[2] + "][" + p[3] + "][" + p[4] + "]");
                idx++;
            }
        }
    }

    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("==== Menu ===");
            System.out.println("1. View all");
            System.out.println("2. Add new");
            System.out.println("3. Quit");
            choice = askInt("Choose an option:");

            switch (choice) {
                case 1 -> {
                    viewAll();
                }
                case 2 -> {
                    System.out.println("==== Add new resource ====");
                    System.out.println("1. Teacher");
                    System.out.println("2. Student");
                    System.out.println("3. Security guard");
                    int opt = askInt("Choose an opt:");
                    switch (opt) {
                        case 1 -> {
                            String fname = askStr("First Name:");
                            String lname = askStr("Last Name:");
                            String sex = askStr("Sex:");
                            String email = askStr("Email:");
                            String subject = askStr("Subject:");
                            int salary = askInt("Salary:");
                            String line = String.join("|",
                                    fname, lname, sex, email, subject, String.valueOf(salary));
                            appendLine(teacherPath, line);
                        }
                        case 2 -> {
                            String fname = askStr("First Name:");
                            String lname = askStr("Last Name:");
                            String sex = askStr("Sex:");
                            String email = askStr("Email:");
                            int year = askInt("Year:");
                            String major = askStr("Major:");
                            String line = String.join("|",
                                    fname, lname, sex, email, String.valueOf(year), major);
                            appendLine(studentPath, line);
                        }
                        case 3 -> {
                            String fname = askStr("First Name:");
                            String lname = askStr("Last Name:");
                            String sex = askStr("Sex:");
                            String email = askStr("Email:");
                            String pos = askStr("Position:");
                            String line = String.join("|",
                                    fname, lname, sex, email, pos);
                            appendLine(guardPath, line);
                        }
                        default -> System.out.println("Invalid option.");
                    }
                }
                case 3 -> choice = -1;
                default -> System.out.println("Try pick 1-3");
            }
        } while (choice != -1);
    }
}