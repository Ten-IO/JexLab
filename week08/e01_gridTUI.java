package week08;

import java.util.Scanner;
import lib_den.LabTUI;

public class e01_gridTUI {
    public interface GridLayout {
        int ROW = 8, COL = 8;
        static int arr[][] = new int[8][8];

        void insertAtRow(int rowNumber, int[] values);

        void insertAtColumn(int colNumber, int values[]);

        void clearAtRow(int rowNumber);

        void clearAtCol(int colNumber);

        void updateCell(int rowNumber, int colNumber, int value);

        void displayGrid();

        void clear();
    }

    public class gridTUI implements GridLayout {
        static {
            for (int i = 0; i < ROW; i++)
                for (int j = 0; j < COL; j++)
                    arr[i][j] = 0;
        }

        @Override
        public void insertAtRow(int rowNumber, int[] values) {
            for (int j = 0; j < COL; j++)
                arr[rowNumber][j] = values[j];
        }

        @Override
        public void insertAtColumn(int colNumber, int[] values) {
            for (int i = 0; i < ROW; i++)
                arr[i][colNumber] = values[i];
        }

        @Override
        public void clearAtRow(int rowNumber) {
            for (int j = 0; j < COL; j++)
                arr[rowNumber][j] = 0;
        }

        @Override
        public void clearAtCol(int colNumber) {
            for (int i = 0; i < ROW; i++)
                arr[i][colNumber] = 0;
        }

        @Override
        public void updateCell(int rowNumber, int colNumber, int value) {
            arr[rowNumber][colNumber] = value;
        }

        @Override
        public void displayGrid() {
            System.out.print("\n" + "    ");
            for (int i = 0; i < COL; i++)
                System.out.print(i + " ");
            System.out.print("\n" + "    ");
            for (int i = 0; i < COL; i++)
                System.out.print("- ");
            System.out.println();
            for (int i = 0; i < ROW; i++) {
                System.out.print(i + " - ");
                for (int j = 0; j < COL; j++)
                    System.out.print(j == COL - 1 ? arr[i][j] + "\n" : arr[i][j] + " ");
            }
        }

        @Override
        public void clear() {
            for (int i = 0; i < ROW; i++)
                for (int j = 0; j < COL; j++)
                    arr[i][j] = 0;
        }
    }

    static Scanner scan = new Scanner(System.in);

    static int input(String prompt) {
        System.out.print(prompt);
        return scan.nextInt();
    }

    static int[] inputArr(String prompt, int size) {

        int res[] = new int[size];
        System.out.print(prompt);
        String line = scan.nextLine();
        while (line.trim().isEmpty())
            line = scan.nextLine();
        String[] seg = line.split("\\s+");
        for (int i = 0; i < size; i++)
            try {
                res[i] = Integer.parseInt(seg[i]);
            } catch (Exception e) {
                res[i] = 0;
            }
        return res;
    }

    public static void main(String args[]) {
        GridLayout grid = new e01_gridTUI().new gridTUI();
        int choice = 0;

        String list[] = { "Update a single cell", "Insert at a row", "Insert at a column", "Clear at a row",
                "Clear at a column", "Clear all", "Quit" };
        LabTUI.setmenu_decore(":");
        do {
            LabTUI.create("The GRID", new Runnable[] { () -> grid.displayGrid() }, list);
            choice = input("Choose an opt: ");
            switch (choice) {
                case 1:
                    grid.updateCell(input("Row: "), input("Column: "), input("Value:"));
                    break;
                case 2:
                    grid.insertAtRow(input("Row: "), inputArr("Value: ", GridLayout.ROW));
                    break;
                case 3:
                    grid.insertAtColumn(input("Column: "), inputArr("Value: ", GridLayout.COL));
                    break;
                case 4:
                    grid.clearAtRow(input("Row: "));
                    break;
                case 5:
                    grid.clearAtCol(input("Column: "));
                    break;
                case 6:
                    grid.clear();
                    break;
                case 7:
                    System.out.println("By3!");
                    return;
                default:
                    System.out.println("Unknown choice!");
                    break;
            }
        } while (choice != 7);

    }
}
