/**
 * a program to create a class to handle multiple task processes at the same time by using Thread. 
 * ▪ Use Thread class or Runnable interface to create sub-process
 * ▪ Use Thread.sleep() to create fake task delay duration 
 * ▪ Refreshthepercentage of task completion in everysecond
 */
package week09;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Scanner;

public class e01_multiProcess {
    static Scanner scan = new Scanner(System.in);

    // Abstract Blueprint
    abstract class Task {
        int duration;
        String name;
    }

    // Process Task
    class TaskProcess implements Runnable {
        Task task;

        TaskProcess(Task task) {
            this.task = task;
        }

        @Override
        public void run() {
            long start = System.currentTimeMillis();
            float step = task.duration / 6.0f;
            for (int i = 1; i <= 6; i++) {
                float percent = i * 100.0f / 6; // 20%, 40%, ..., 100%
                System.out.printf("%02ds # ::: Executing %10s >> - %.2f%% - processing :::%n",
                        (int) ((System.currentTimeMillis() - start) / 1e3), task.name, percent);
                try {
                    Thread.sleep((long) step);
                } catch (InterruptedException e) {
                    System.out.println(e.getClass().getSimpleName());
                }
            }
        }

        public Task getTask() {
            return task;
        }
    }

    static int input(String prompt) {
        System.out.print(prompt);
        return scan.nextInt();
    }

    static String inputStr(String prompt) {
        System.out.print(prompt);
        String res = scan.nextLine();
        while (res.isEmpty())
            res = scan.nextLine();
        return res;
    }

    static void display(ArrayList<TaskProcess> ls) {
        if (ls.isEmpty())
            return;
        System.out.println("_".repeat(60));
        System.out.printf("| %5s | %30s | %15s |%n", "No", "Name", "Duration");
        System.out.printf("|%7s|%32s|%17s|%n", "_".repeat(7), "_".repeat(32), "_".repeat(17));
        for (int i = 0; i < ls.size(); i++)
            System.out.printf("| %5s | %30s | %15s |%n", i, ls.get(i).getTask().name,
                    ls.get(i).getTask().duration + "ms");
        System.out.printf("|%7s|%32s|%17s|%n", "_".repeat(7), "_".repeat(32), "_".repeat(17));

    }

    public static void main(String[] args) {
        ArrayList<TaskProcess> ls = new ArrayList<>();
        int choice;
        do {
            System.out.println("\n::: Task Handler :::");
            display(ls);
            System.out.println("1. Add new task\n2. Delete a task\n3. Proceed tasks\n4. Exit");
            choice = input("Choose an option: ");
            scan.nextLine(); // consume leftover newline

            switch (choice) {
                case 1:
                    ls.add(new e01_multiProcess().new TaskProcess(new e01_multiProcess().new Task() {
                        {
                            name = inputStr("Task Name : ");
                            duration = input("Timer(ms): ");
                        }
                    }));
                    break;
                case 2:
                    int idx = input("Index of task: ");
                    scan.nextLine(); // consume leftover newline
                    if (idx >= 0 && idx < ls.size())
                        ls.remove(idx);
                    else
                        System.out.println("Invalid index!");
                    break;
                case 3:
                    if (ls.isEmpty()) {
                        System.out.println("No tasks to run!");
                        break;
                    }
                    ArrayList<Thread> pool = new ArrayList<>();
                    LinkedHashSet<Integer> selected = new LinkedHashSet<>();
                    char c;
                    do {
                        int taskIdx = input("Index of task: ");
                        scan.nextLine(); // consume newline
                        if (taskIdx >= 0 && taskIdx < ls.size()) {
                            selected.add(taskIdx);
                        } else {
                            System.out.println("Invalid index!");
                        }
                        c = inputStr("Do you want to add more tasks? y/n: ").toLowerCase().charAt(0);
                    } while (c == 'y');

                    // Run tasks concurrently
                    selected.forEach(i -> {
                        Thread t = new Thread(ls.get(i));
                        t.start();
                        pool.add(t);
                    });
                    for (Thread t : pool)
                        try {
                            t.join();
                        } catch (Exception e) {
                            System.out.println(e.getClass().getSimpleName());
                        }
                    selected.forEach(i -> ls.remove((int) i));
                    break;
                case 4:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice!");
                    break;
            }
        } while (choice != 4);
    }
}
