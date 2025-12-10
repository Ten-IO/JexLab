/*
 * Write a program to allow user to infinitely input student to a table by using Array of Student Class. 
 * You can suggest Attributes (id, name, age, etc.)
 */
package week04;

import java.util.ArrayList;
import java.util.Scanner;

public class e01_infStudent {
    static class Student {
        int id, age;
        String name;
    }

    public static void main(String[] args) {
        boolean run = true;
        int i = 0;
        ArrayList<Student> list = new ArrayList<Student>();
        try (Scanner scan = new Scanner(System.in)) {
            do {
                // Init instance
                Student s = new Student();
                System.out.printf("Student #%d:%nID: ", ++i);
                s.id = scan.nextInt();
                scan.nextLine();
                System.out.print("Name: ");
                s.name = scan.nextLine();
                System.out.print("Age: ");
                s.age = scan.nextInt();
                // Update list
                list.add(s);
                System.out.print("\nDo you want to add more (y/n)?: ");
                String input = scan.next();
                run = input.equalsIgnoreCase("y") ? true : false;
                // If input is NOT 'n' and NOT 'y'
                if (!input.equalsIgnoreCase("n") && !run)
                    throw new IllegalArgumentException("Invalid input");
            } while (run);
            i = 0;
            System.out.println(" _______________________________________");
            System.out.printf("| %-2s | %-3s | %-20s | %-3s |%n", "No", "ID", "Name", "Age" );
            System.out.println("|____|_____|______________________|_____|");
            for (Student s: list)
                System.out.printf("| %02d | %03d | %-20s | %3d |%n", ++i, s.id, s.name, s.age );
            System.out.print("|____|_____|______________________|_____|");
        } catch (Exception e) {
            System.out.println("[!] Error: " + e.getClass().getSimpleName());
        }
    }
}