/*
    A program to allow user to work with date and time. Create a class called “MyDate” with following methods:--
    calculateDaysBtwDates
    findDay
*/
package week05;

import java.util.ArrayList;
import java.util.Scanner;

public class e02_MultiDeletion {
    static Scanner scan = new Scanner(System.in);

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
    static class Student {
        int id;
        String name;
        int age;

        Student(int id, String name, int age) {
            this.id = id;
            this.name = name;
            this.age = age;
        }
    }
    static void printTable(ArrayList<Student> list) {
        System.out.println("=============================================================");
        System.out.println("| No | ID | Name | Age |");
        System.out.println("=============================================================");
        int i = 1;
        for (Student s : list) {
            System.out.println("| " + i + " | " + s.id + " | " + s.name + " | " + s.age + " |");
            i++;
        }
        System.out.println("=============================================================");
    }

    public static void main(String[] args) {
        ArrayList<Student> list = new ArrayList<>();
        int choice;

        do {
            System.out.println("==== Menu ===");
            System.out.println("1. Add new students");
            System.out.println("2. Delete multiple students");
            System.out.println("3. Quit");
            choice = askInt("Choose an opt:");

            switch (choice) {
                case 1 -> {
                    int count = list.size() + 1;
                    while (true) {
                        System.out.println("Student #" + count + ":");
                        int id = askInt("Id:");
                        String name = askStr("Name:");
                        int age = askInt("Age:");
                        list.add(new Student(id, name, age));
                        System.out.print("Do you want to add more (y/n)?: ");
                        String more = scan.nextLine();
                        if (!more.equalsIgnoreCase("y")) break;
                        count++;
                    }
                }
                case 2 -> {
                    if (list.isEmpty()) {
                        System.out.println("No students available.");
                        break;
                    }
                    printTable(list);
                    System.out.println("==== DELETION =====");
                    ArrayList<Integer> idsToDelete = new ArrayList<>();
                    int index = 1;
                    while (true) {
                        int id = askInt("Input student #" + index + " ID:");
                        idsToDelete.add(id);
                        System.out.print("Do you want to delete more (y/n)?: ");
                        String more = scan.nextLine();
                        if (!more.equalsIgnoreCase("y")) break;
                        index++;
                    }

                    for (int id : idsToDelete) {
                        boolean removed = false;
                        for (int i = 0; i < list.size(); i++) {
                            if (list.get(i).id == id) {
                                list.remove(i);
                                removed = true;
                                break;
                            }
                        }
                        if (removed) {
                            System.out.println("Student with ID " + id + " deleted");
                        } else {
                            System.out.println("Student with ID " + id + " not found!");
                        }
                    }
                }
                case 3 -> choice = -1;
                default -> System.out.println("Try pick 1-3");
            }
        } while (choice != -1);
    }
}
