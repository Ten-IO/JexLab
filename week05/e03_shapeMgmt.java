/*
 a program to allow user mange different shapes of geometry.
 You can suggest Attributes according to the shapes Line, Rectangles and 
Triangle
 */
package week05;

import java.util.ArrayList;
import java.util.Scanner;

public class e03_shapeMgmt {

    static class Shape {
        Shape() {
            System.out.println("Shape created");
        }
        void show() {
            System.out.println("I'm a shape but I don't exist");
        }

        String getInfo() {
            return "I don't have the info";
        }
    }
    static class Line extends Shape {
        int length;
        Line(int length) {
            this.length = length;
        }
        void show() {
            System.out.println(getInfo());
            for (int i = 0; i < length; i++)
                System.out.print("_");
        }
        String getInfo() {
            return "\nLength: " + this.length;
        }
    }

    static class Rectangle extends Shape {
        int w, h;
        Rectangle(int w, int h) {
            this.w = w;
            this.h = h;
        }
        void show() {
            String res = "";
            for (int i = 1; i <= h; i++) {
                for (int j = 1; j <= w; j++)
                    if (i == 1 || i == h || j == 1 || j == w)
                        res += '*';
                    else
                        res += ' ';
                res += '\n';
            }
            System.out.println(getInfo() + '\n' + res);
        }
        String getInfo() {
            return "\nWidth: " + this.w + ' ' + "Height: " + this.h;
        }
    }

    static class Triangle extends Shape {
        int b, h;
        Triangle(int b, int h) {
            this.b = b;
            this.h = h;
        }
        void show() {
            String res = "", line;
            for (int i = b; i > 0; i -= 2) {
                line = "";
                for (int s = 0; s < (b - i) / 2; s++)
                    line += " ";
                for (int j = 0; j < i; j++)
                    line += '*';
                res += line + '\n';
            }
            System.out.println(getInfo() + '\n' + res);
        }
        String getInfo() {
            return "\nBase: " + this.b + ' ' + "Height: " + this.h;
        }
    }

    static int ask(Scanner scan, String text) {
        System.out.print(text);
        int choice = scan.nextInt();
        return choice;
    }

    public static void main(String args[]) {
        ArrayList<Shape> ls = new ArrayList<>();
        int choice = 0;
        try (Scanner scan = new Scanner(System.in)) {
            do {
                System.out.println(
                        "\n== Menu ==\n1. View all lines\n2. View all rectangles\n3. View all triangles\n4. Add a new shape\n5. Quit");
                choice = ask(scan, "Choose an opt: ");
                switch (choice) {
                    case 1:
                        for (Shape s : ls)
                            if (s instanceof Line)
                                s.show();
                        break;
                    case 2:
                        for (Shape s : ls)
                            if (s instanceof Rectangle)
                                s.show();
                        break;
                    case 3:
                        for (Shape s : ls)
                            if (s instanceof Triangle)
                                s.show();
                        break;
                    case 4:
                        System.out.println(
                                "\n=== Add new shape ===\nSelect a shape:\n1. line\n2. rectangle\n3. triangle");
                        int type = ask(scan, "Choose an opt: ");
                        switch (type) {
                            case 1:
                                ls.add(new Line(ask(scan, "Length: ")));
                                break;
                            case 2:
                                ls.add(new Rectangle(ask(scan, "Width: "), ask(scan, "Height: ")));
                                break;
                            case 3:
                                ls.add(new Triangle(ask(scan, "Base: "), ask(scan, "Height: ")));
                                break;
                            default:
                                System.out.println("No choice picked");
                                break;
                        }
                        break;
                    case 5:
                        System.out.println("Goodbye!");
                        System.exit(0);
                        break;
                    default:
                        System.out.println("You are a mistake");
                        break;
                }
            } while (choice != 5);
        } catch (Exception e) {
            System.out.println("Error: " + e.getClass().getSimpleName());
        }
    }
}