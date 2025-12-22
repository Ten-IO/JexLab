/*
    Text editor
 */
package week05;

import java.util.*;
import java.nio.file.*;
import java.io.IOException;
import java.util.Scanner;

public class e04_noteTaker {
    static Scanner scan = new Scanner(System.in);
    static Path path = Paths.get("data.txt");

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

    static List<String> readNote() {
        try {
            if (!Files.exists(path)) {
                Files.createFile(path);
            }
            return new ArrayList<>(Files.readAllLines(path));
        } catch (IOException e) {
            System.out.println("[!] Error reading file");
            return new ArrayList<>();
        }
    }

    static void writeNote(List<String> lines) {
        try {
            Files.write(path, lines);
        } catch (IOException e) {
            System.out.println("[!] Error writing file");
        }
    }

    static void printNote(List<String> lines) {
        System.out.println("*****************************");
        for (int i = 0; i < lines.size(); i++) {
            System.out.println((i + 1) + "| " + lines.get(i));
        }
        System.out.println("*****************************");
    }

    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("==== Menu ===");
            System.out.println("1. View my note");
            System.out.println("2. Edit");
            System.out.println("3. Quit");
            choice = askInt("Choose an option:");

            switch (choice) {
                case 1 -> {
                    System.out.println("==== View note ====");
                    List<String> note = readNote();
                    printNote(note);
                }
                case 2 -> {
                    List<String> note = readNote();
                    System.out.println("==== Edit following note ====");
                    printNote(note);
                    boolean keepEditing = true;
                    while (keepEditing) {
                        System.out.println("1. Append new line");
                        System.out.println("2. Update at line");
                        System.out.println("3. Delete line");
                        int opt = askInt("Choose an opt:");
                        switch (opt) {
                            case 1 -> {
                                int nextLine = note.size() + 1;
                                String text = askStr("Input a string for line #" + nextLine + ":");
                                note.add(text);
                                writeNote(note);
                                System.out.println("Line #" + nextLine + " is appended to the note.");
                            }
                            case 2 -> {
                                int line = askInt("Update at line number:");
                                if (line >= 1 && line <= note.size()) {
                                    String text = askStr("Input new string for line #" + line + ":");
                                    note.set(line - 1, text);
                                    writeNote(note);
                                    System.out.println("Line #" + line + " is updated.");
                                } else {
                                    System.out.println("Invalid line number.");
                                }
                            }
                            case 3 -> {
                                int line = askInt("Delete line number:");
                                if (line >= 1 && line <= note.size()) {
                                    note.remove(line - 1);
                                    writeNote(note);
                                    System.out.println("Line #" + line + " is deleted.");
                                } else {
                                    System.out.println("Invalid line number.");
                                }
                            }
                            default -> System.out.println("Invalid option.");
                        }
                        System.out.print("Do you want to continue editing (y/n)?: ");
                        String more = scan.nextLine();
                        if (!more.equalsIgnoreCase("y"))
                            keepEditing = false;
                    }
                }
                case 3 -> choice = -1;
                default -> System.out.println("Try pick 1-3");
            }
        } while (choice != -1);
    }
}