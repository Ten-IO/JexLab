/* 
 * Implement an application in Java to display and navigate Menu of “Phone Setting”
*/
package week03;

import java.util.Scanner;

public class e03_Setting {
    static void display(String[] list) {
        System.out.println(list[0] + ':');
        for (int i = 1; i < list.length - 1; i++)
            System.out.printf("%d. %-20s >%n", i, list[i]);
        System.out.printf("0. %s%n", list[list.length - 1]);
    }

    static void display(String[] list, String[] val) {
        System.out.println(list[0] + ':');
        for (int i = 1; i < list.length - 1; i++)
            System.out.printf("%-22s %s%n", list[i], val[i]);
        System.out.printf("0. %s%n", list[list.length - 1]);
    }

    // Accepting prompt while scanning with Scanner
    static int read(Scanner scan, String prompt) {
        System.out.print(prompt);
        return scan.nextInt();
    }

    public static void main(String arg[]) {
        try (Scanner scan = new Scanner(System.in)) {
            String setting[][] = {
                    { "Phone Setting", "General", "Wi-Fi", "Bluetooth", "Mobile Data", "Hotspot", "Notification",
                            "Quit" },
                    { "General", "About", "Software update", "Storage", "Back" },
                    { "General > About", "Name", "Model", "Version", "Back" },
                    { "General > Software Update:", "Software is up to date", "Back" },
                    { "Wi-Fi", "Status", "Network", "1. Other networks", "Back" },
                    { "Wi-Fi > Other Networks", "Bayon Coffee", "Angkor Coffee", "Brown Coffee", "Koi", "Back" },
                    { "Title", "============================\nThe Feature is not available", "Back" }
            }, val[][] = new String[setting.length][7];
            val[2] = new String[] { " ", "iPhone", "IXs", "18.5", " " };
            val[4] = new String[] { " ", "On", "I-Coffee", ">", " " };
            val[5] = new String[] { " ", "*****", "**", "****", "*", " " };
            val[6] = new String[] { " ", "\n============================", " " };
            int choice = 1;

            do {
                display(setting[0]);
                System.out.print("\n>> To: ");
                choice = scan.nextInt();
                boolean back = false;
                switch (choice) {
                    /* General */
                    case 1:
                        do {
                            display(setting[1]);
                            int innerChoice = read(scan, "\n>> To: ");
                            switch (innerChoice) {
                                // About
                                case 1:
                                    display(setting[2], val[2]);
                                    // pattern for going back to root
                                    back = 0 == read(scan, "\n>> To: ") ? true : false;
                                    break;
                                // software
                                case 2:
                                    display(setting[6], val[6]);
                                    back = read(scan, "\n>> To: ") == 0 ? true : false;
                                    break;
                                // Storage
                                case 3:
                                    display(setting[6], val[6]);
                                    back = read(scan, "\n>> To: ") == 0 ? true : false;
                                    break;
                                default:
                                    back = true;
                                    break;
                            }
                        } while (!back);
                        break;

                    /* Wi-Fi */
                    case 2:
                        do {
                            display(setting[4], val[4]);
                            int innerChoice = read(scan, "\n>> To: ");
                            switch (innerChoice) {
                                // Other networks
                                case 1:
                                    display(setting[5], val[5]);
                                    back = read(scan, "\n>> To: ") == 0 ? true : false;
                                    break;
                                default:
                                    back = true;
                                    break;
                            }
                        } while (!back);
                        break;

                    /* Bluetooth */
                    case 3:
                        do {
                            display(setting[6], val[6]);
                            back = read(scan, "\n>> To: ") == 0 ? true : false;
                        } while (!back);
                        break;

                    /* Mobile data */
                    case 4:
                        do {
                            display(setting[6], val[6]);
                            back = read(scan, "\n>> To: ") == 0 ? true : false;
                        } while (!back);
                        break;

                    /* Hotspot */
                    case 5:
                        do {
                            display(setting[6], val[6]);
                            back = read(scan, "\n>> To: ") == 0 ? true : false;
                        } while (!back);
                        break;

                    /* Notification */
                    case 6:
                        do {
                            display(setting[6], val[6]);
                            back = read(scan, "\n>> To: ") == 0 ? true : false;
                        } while (!back);
                        break;
                    default:
                        break;
                }
            } while (choice != 0);
        } catch (Exception e) {
            System.out.println("[!] Error: " + e.getClass().getSimpleName());
        }
    }
}
