/*
    A program to allow user to work with date and time. Create a class called “MyDate” with following methods:--
    calculateDaysBtwDates
    findDay
  */
package week05;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class e01_date {
    static Scanner scan = new Scanner(System.in);
    static int askInt(Scanner scan, String prompt) {
        prompt = prompt.endsWith(" ") ? prompt : prompt + ' ';
        System.out.print(prompt);
        int res = scan.nextInt();
        scan.nextLine();
        return res;
    }
    static String askStr(Scanner scan, String prompt) {
        prompt = prompt.endsWith(" ") ? prompt : prompt + ' ';
        System.out.print(prompt);
        return scan.nextLine();
    }
    class MyDate {
        SimpleDateFormat format; 
        MyDate(String style){
        format = new SimpleDateFormat(style);
}
        String getCurrentDate() {
            SimpleDateFormat tmp = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
            return tmp.format(new Date());
        }
        void calculateDaysBtwDates(String date_01, String date_02) throws ParseException {
            Date d[] = new Date[] { format.parse(date_01), format.parse(date_02) };
            long diff = d[1].getTime() - d[0].getTime(); // type(diff) = miliseconds
            System.out.println("Difference between two dates is: " + diff / 86400000); // convert to days from
                                                                                       // milisecond = 60*60*24 * 1000
        }
        void findDay(String input) throws ParseException {
            Date date = format.parse(input);
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);
             String[] days = {"Sunday","Monday","Tuesday","Wednesday","Thursday","Friday","Saturday"};
            int index = calendar.get(Calendar.DAY_OF_WEEK) - 1;
             System.out.println("The day is: " + days[index]);
        }
    }

    public static void main(String[] args) {
        int choice;
        MyDate date  = new e01_date().new MyDate("dd/MM/yyyy");
        do {
            System.out.println("""
                        === Menu ===
                        1. Current date
                        2. Calculate days btw two dates
                        3. Find the day of the week
                        4. Quit
                    """);
            choice = askInt(scan, "Choose: ");
            try {
                switch (choice) {
                    case 1:
                        System.out.println("Current datetime is: " + date.getCurrentDate());
                        break;

                    case 2:
                        date.calculateDaysBtwDates(askStr(scan, "1st date (dd/mm/yyyy): "),
                                askStr(scan, "2nd date (dd/mm/yyyy): "));
                        break;
                    case 3:
                        date.findDay(askStr(scan, "Input date: "));
                        break;

                    case 4:
                        choice = -1;
                        break;
                    default:
                        System.out.println("Try pick 1-4");
                        break;
                }
            } catch (Exception e) {
                System.out.println("[!] Error: " + e.getClass().getSimpleName());
            }
        } while (choice != -1);
    }
}
