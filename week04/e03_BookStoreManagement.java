package week04;
import java.util.Scanner;

public class e03_BookStoreManagement {
    static class Book {
        String isbn, title, author;
        double price;
    }

    public static void main(String[] args) {
        Book[] books = new Book[100];
        int count = 0, choice;
        Scanner scan = new Scanner(System.in);
        do {
            System.out.println("\n=== Menu ===");
            System.out.println("1. View all books");
            System.out.println("2. Add a new book");
            System.out.println("3. Update a book");
            System.out.println("4. Quit");
            System.out.print("Choose an option: ");
            choice = scan.nextInt();
            scan.nextLine();

            switch (choice) {
                case 1:
                    System.out.println(" _________________________________________________________");
                    System.out.printf("| %-2s | %-10s | %-20s | %-8s | %-10s |%n", "No", "ISBN", "Title", "Price", "Author");
                    System.out.println("|____|___________|______________________|_________|____________|");
                    for (int i = 0; i < count; i++) 
                        System.out.printf("| %-2d | %-10s | %-20s | %-7.2f | %-10s |%n", i + 1, books[i].isbn, books[i].title, books[i].price, books[i].author);
                    System.out.println("|____|___________|______________________|_________|____________|");
                    break;
                case 2:
                    if (count >= 100) {
                        System.out.println("Book list is full!");
                        break;
                    }
                    Book b = new Book();
                    System.out.print("ISBN: ");
                    b.isbn = scan.nextLine();
                    System.out.print("Title: ");
                    b.title = scan.nextLine();
                    System.out.print("Price: ");
                    b.price = scan.nextDouble();
                    scan.nextLine();
                    System.out.print("Author: ");
                    b.author = scan.nextLine();
                    books[count++] = b;
                    System.out.println("Book added.");
                    break;
                case 3:
                    System.out.print("Input ISBN to update: ");
                    String isbn = scan.nextLine();
                    boolean found = false;
                    for (int i = 0; i < count; i++) {
                        if (books[i].isbn.equals(isbn)) {
                            found = true;
                            System.out.println("Please update the following:");
                            System.out.print("ISBN: ");
                            books[i].isbn = scan.nextLine();
                            System.out.print("Title: ");
                            books[i].title = scan.nextLine();
                            System.out.print("Price: ");
                            books[i].price = scan.nextDouble();
                            scan.nextLine();
                            System.out.print("Author: ");
                            books[i].author = scan.nextLine();
                            System.out.println("Book updated.");
                            break;
                        }
                    }
                    if (!found) System.out.println("Book not found.");
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