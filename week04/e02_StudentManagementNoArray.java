/* 
* Write a program to allow user mange a list of student by using normal Array not ArrayList. 
* You can suggest Attributes (id, name, age, etc.)
 */
package week04;
import java.util.Scanner;

public class e02_StudentManagementNoArray {
    static class Student {
        int id, age;
        String name;
    }

    public static void main(String[] args) {
        Student[] students = new Student[100];
        int count = 0;
        Scanner scan = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n=== Menu ===");
            System.out.println("1. View all students");
            System.out.println("2. Add a new student");
            System.out.println("3. Delete a student");
            System.out.println("4. Quit");
            System.out.print("Choose an option: ");
            choice = scan.nextInt();

            switch (choice) {
                case 1:
                    System.out.println(" _______________________________________");
                    System.out.printf("| %-2s | %-3s | %-20s | %-3s |%n", "No", "ID", "Name", "Age");
                    System.out.println("|____|_____|______________________|_____|");
                    for (int i = 0; i < count; i++) {
                        System.out.printf("| %-2d | %-3d | %-20s | %-3d |%n", i + 1, students[i].id, students[i].name, students[i].age);
                    }
                    System.out.println("|____|_____|______________________|_____|");
                    break;

                case 2:
                    if (count >= 100) {
                        System.out.println("Student list is full!");
                        break;
                    }
                    Student s = new Student();
                    System.out.print("ID: ");
                    s.id = scan.nextInt();
                    scan.nextLine();
                    System.out.print("Name: ");
                    s.name = scan.nextLine();
                    System.out.print("Age: ");
                    s.age = scan.nextInt();
                    students[count++] = s;
                    System.out.println("Student added.");
                    break;

                case 3:
                    System.out.print("Input student ID to delete: ");
                    int deleteId = scan.nextInt();
                    boolean found = false;
                    for (int i = 0; i < count; i++) {
                        if (students[i].id == deleteId) {
                            found = true;
                            System.out.println("Student deleted:");
                            System.out.printf("| %-2d | %-3d | %-20s | %-3d |%n", i + 1, students[i].id, students[i].name, students[i].age);
                            for (int j = i; j < count - 1; j++) {
                                students[j] = students[j + 1];
                            }
                            count--;
                            break;
                        }
                    }
                    if (!found) System.out.println("Student not found.");
                    break;

                case 4:
                    System.out.println("Goodbye!");
                    break;

                default:
                    System.out.println("Invalid option.");
            }
        } while (choice != 4);
        scan.close();
    }
}