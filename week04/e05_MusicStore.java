package week04;

import java.util.Scanner;

public class e05_MusicStore {
    static class Song {
        String title, singer, length;
        double price;
    }
    static class Album {
        String title, genre;
        Song[] songs = new Song[20];
        int songCount = 0;
    }
    public static void main(String[] args) {
        Album[] albums = new Album[10];
        int albumCount = 0, choice;
        Scanner scan = new Scanner(System.in);
        do {
            System.out.println("\n=== Choose Menu ===");
            System.out.println("1. View music store");
            System.out.println("2. Add a song");
            System.out.println("3. Create an album");
            System.out.println("4. Quit");
            System.out.print("Choose an option: ");
            choice = scan.nextInt();
            scan.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("\n==== Music Store ====");
                    for (int i = 0; i < albumCount; i++) {
                        System.out.println("Album: " + albums[i].title);
                        if (albums[i].songCount == 0) {
                            System.out.println("None of song");
                        } else {
                            for (int j = 0; j < albums[i].songCount; j++) {
                                Song s = albums[i].songs[j];
                                System.out.printf("| %d | %-15s | %-10s | %-6s | %.0f$ |%n", 
                                    j + 1, s.title, s.singer, s.length, s.price);
                            }
                        }
                        System.out.println();
                    }
                    break;
                case 2:
                    if (albumCount == 0) {
                        System.out.println("No albums available. Create an album first.");
                        break;
                    }
                    System.out.println("Select an album:");
                    for (int i = 0; i < albumCount; i++)
                        System.out.println((i + 1) + ". " + albums[i].title);
                    int albumIndex = scan.nextInt() - 1;
                    scan.nextLine();
                    if (albumIndex < 0 || albumIndex >= albumCount) {
                        System.out.println("Invalid album selection.");
                        break;
                    }
                    Song song = new Song();
                    System.out.print("Song title: ");
                    song.title = scan.nextLine();
                    System.out.print("Singer: ");
                    song.singer = scan.nextLine();
                    System.out.print("Length (e.g., 3mins): ");
                    song.length = scan.nextLine();
                    System.out.print("Price: ");
                    song.price = scan.nextDouble();
                    scan.nextLine();
                    albums[albumIndex].songs[albums[albumIndex].songCount++] = song;
                    System.out.println("A new song added to the album");
                    break;
                case 3:
                    Album album = new Album();
                    System.out.print("Album title: ");
                    album.title = scan.nextLine();
                    System.out.print("Genre: ");
                    album.genre = scan.nextLine();
                    albums[albumCount++] = album;
                    System.out.println("Album created.");
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