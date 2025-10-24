/**
 * Questions for Health check regarding to Covid-19
 */
package week02;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class e03_healthChecker {
    static void pairPrint(String t1, String t2) {
        System.out.printf("| %-10s | %-10s |%n", t1, t2);
        System.out.println("|____________|____________|");
    }

    public static void main(String[] args) {
        Map<String, String> data = new LinkedHashMap<>();
        Scanner in = new Scanner(System.in);
        String yes = "yes", no = "nope", res = "";
        String[][] Questions = {
                { "Q1", "Feeling feverish and/or having chills? " },
                { "Q2", "Has there been any use of fever reducing medication within the last 24 hours not due to another health condition? " },
                { "Q3", "A new cough that is not due to another health condition? " },
                { "Q4", "New chills that are not due to another health condition? " },
                { "Q5", "A new sore throat that is not due to another health condition? " },
                { "Q6", "A new loss of taste or smell? " },
                { "Q7", "Have you had a positive test for the virus that causes COVID-19 disease within the past 10 days? " },
                { "Q8", "In the past 14 days, have you had close contact (within about 6 feet for 15 minutes or more) with someone with suspected or confirmed COVID-19? " },
        };
        // Question Session
        System.out.println("== Covid-19 Screen Health ==");
        for (String[] Q : Questions) {
            System.out.printf("%s. %s ", Q[0], Q[1]);
            res = in.nextLine().toLowerCase().trim();
            if (yes.contains(res))
                data.put(Q[0], yes);
            else if (no.contains(res))
                data.put(Q[0], no.substring(0, 2));
            else
                System.out.println("[!] Continue - Unacceptable response: " + res);
        }
        in.close();

        // Table
        System.out.println("===========================");
        pairPrint("Question", "Answer");
        for (Map.Entry<String, String> entry : data.entrySet()) {
            pairPrint(entry.getKey(), entry.getValue());
        }
    }
}