package week03;

import java.util.ArrayList;
import java.util.Scanner;

public class e07_studentMgmt {
    class Student {
        ArrayList<Info> ls = new ArrayList<>();
        int i = 0;

        void setValue(Scanner scan) {
            System.out.println("Student #" + ++i + ':');
            int id = readInt(scan, "ID: ");
            scan.nextLine();
            System.out.print("Name: ");
            String name = scan.nextLine();
            int age = readInt(scan, "Age: ");
            ls.add(new Info(id, age, name));
            System.out.println("A Student is added to the list.");
        }

        void display() {
            int i = 0;
            System.out.println(" _______________________________________");
            System.out.printf("| %-2s | %-3s | %-20s | %-3s |%n", "No", "ID", "Name", "Age");
            System.out.println("|____|_____|______________________|_____|");
            for (Info s : ls)
                System.out.printf("| %02d | %03d | %-20s | %3d |%n", ++i, s.id, s.name, s.age);
            System.out.println("|____|_____|______________________|_____|");
        }
    }

    class Info {
        int id, age;
        String name;

        public Info(int id, int age, String name) {
            this.id = id;
            this.age = age;
            this.name = name;
        }
    }

    static int readInt(Scanner scan, String prompt) {
        System.out.print(prompt);
        return scan.nextInt();
    }

    public static void main(String args[]) {
        Student DBLS = new e07_studentMgmt().new Student();
        try (Scanner scan = new Scanner(System.in)) {
            boolean stop = false;
            do {
                System.out.println("\n=== Menu ===\n1. Create a Student\n2. List Students\n3. Quit");
                int choice = readInt(scan, "Choose an option: ");
                switch (choice) {
                    case 1:
                        DBLS.setValue(scan);
                        break;
                    case 2:
                        DBLS.display();
                        break;
                    default:
                        stop = true;
                        break;
                }
            } while (!stop);
        } catch (Exception e) {
            System.out.println("[!] Error: " + e.getClass().getSimpleName());
        }
    }
}
