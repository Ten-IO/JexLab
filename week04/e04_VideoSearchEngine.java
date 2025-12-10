package week04;

import java.util.Scanner;

public class e04_VideoSearchEngine {
    static class Video {
        String title, uploader, type;
        int length;
    }
    public static void main(String[] args) {
        Video[] videos = new Video[100];
        int count = 0, choice;
        Scanner scan = new Scanner(System.in);
        do {
            System.out.println("\n=== Menu ===");
            System.out.println("1. Search");
            System.out.println("2. View all videos");
            System.out.println("3. Add a new video");
            System.out.println("4. Quit");
            System.out.print("Choose an option: ");
            choice = scan.nextInt();
            scan.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Input title to search: ");
                    String keyword = scan.nextLine().toLowerCase();
                    int foundCount = 0;
                    for (int i = 0; i < count; i++) 
                        if (videos[i].title.toLowerCase().contains(keyword)) 
                            foundCount++;
                    System.out.println(foundCount + " video(s) found.");
                    for (int i = 0; i < count; i++) 
                        if (videos[i].title.toLowerCase().contains(keyword)) 
                            System.out.println((i + 1) + ". " + videos[i].title + " by " + videos[i].uploader);
                    break;
                case 2:
                    System.out.println(" _________________________________________________________");
                    System.out.printf("| %-2s | %-20s | %-15s | %-6s | %-10s |%n", "No", "Title", "Uploader", "Length", "Type");
                    System.out.println("|____|______________________|_________________|________|____________|");
                    for (int i = 0; i < count; i++) 
                        System.out.printf("| %-2d | %-20s | %-15s | %-6d | %-10s |%n", i + 1, videos[i].title, videos[i].uploader, videos[i].length, videos[i].type);
                    System.out.println("|____|______________________|_________________|________|____________|");
                    break;
                case 3:
                    if (count >= 100) {
                        System.out.println("Video list is full!");
                        break;
                    }
                    Video v = new Video();
                    System.out.print("Title: ");
                    v.title = scan.nextLine();
                    System.out.print("Uploader: ");
                    v.uploader = scan.nextLine();
                    System.out.print("Length (seconds): ");
                    v.length = scan.nextInt();
                    scan.nextLine();
                    System.out.print("Type: ");
                    v.type = scan.nextLine();
                    videos[count++] = v;
                    System.out.println("Video added.");
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