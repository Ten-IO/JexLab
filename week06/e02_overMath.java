/**
 *  a program to create a math class with following return 
* methods:
* ▪ sum (with 2 params) 
* ▪ sum (with 3 params) 
* ▪ sum (with array of value) 
* ▪ multiply (with 2 params) 
* ▪ multiply (with 3 params) 
* ▪ multiply (with array of value) 
* ▪ max (with 3 params) 
* ▪ max (with 4 params) 
* ▪ max (with array of value) 
* ▪ min (with 3 params) 
* ▪ min (with 4 params) 
* ▪ min (with array of value) 
* ▪ average (with 3 params) 
* ▪ average (with 4 params) 
* ▪ average (with array of value)
 */
package week06;

import java.util.Scanner;

public class e02_overMath {
	// SUM
	int sum(int a, int b) { return a + b; }
	int sum(int a, int b, int c) { return a + b + c; }
	int sum(int[] values) {
		int s = 0;
		for (int v : values)
			s += v;
		return s;
	}

	// MULTIPLY
	int multiply(int a, int b) { return a * b; }
	int multiply(int a, int b, int c) { return a * b * c; }
	int multiply(int[] values) {
		int p = 1;
		for (int v : values)
			p *= v;
		return p;
	}
	// MAX
	int max(int a, int b, int c) {
		int m = a;
		if (b > m)
			m = b;
		if (c > m)
			m = c;
		return m;
	}
	int max(int a, int b, int c, int d) {
		int m = max(a, b, c);
		if (d > m)
			m = d;
		return m;
	}
	int max(int[] values) {
		int m = values[0];
		for (int v : values)
			if (v > m)
				m = v;
		return m;
	}
	// MIN
	int min(int a, int b, int c) {
		int m = a;
		if (b < m)
			m = b;
		if (c < m)
			m = c;
		return m;
	}
	int min(int a, int b, int c, int d) {
		int m = min(a, b, c);
		if (d < m)
			m = d;
		return m;
	}
	int min(int[] values) {
		int m = values[0];
		for (int v : values)
			if (v < m)
				m = v;
		return m;
	}
	// AVERAGE
	double average(int a, int b, int c) { return (a + b + c) / 3.0; }
	double average(int a, int b, int c, int d) { return (a + b + c + d) / 4.0; }
	double average(int[] values) {return sum(values) / (double) values.length;}
	public static void main(String[] args) {
		e02_overMath m = new e02_overMath();
		Scanner scan = new Scanner(System.in);
		int choice;
		do {
			System.out.println("\n=== Menu ===");
			System.out.println(
					"1. sum(a,b)\n2. sum(a,b,c)\n3. sum(array)\n4. multiply(a,b)\n5. multiply(a,b,c)\n6. multiply(array)");
			System.out.println(
					"7. max(a,b,c)\n8. max(a,b,c,d)\n9. max(array)\n10. min(a,b,c)\n11. min(a,b,c,d)\n12. min(array)");
			System.out.println("13. average(a,b\n14. average(a,b,c)\n15. average(array)\n16. Exit");
			choice = input("Enter choice: ");
			try {
				switch (choice) {
					case 1:
						System.out.println("Result: " + m.sum(input("a: "), input("b: ")));
						break;
					case 2:
						System.out.println("Result: " + m.sum(input("a: "), input("b: "), input("c: ")));
						break;
					case 3:
						System.out.println("Result: " + m.sum(inputArray("Enter integers separated by space: ")));
						break;
					case 4:
						System.out.println("Result: " + m.multiply(input("a: "), input("b: ")));
						break;
						case 5:
						System.out.println("Result: " + m.multiply(input("a: "), input("b: "), input("c: ")));
						break;
					case 6:
						System.out.println("Result: " + m.multiply(inputArray("Enter integers separated by space: ")));
						break;
					case 7:
						System.out.println("Result: " + m.max(input("a: "), input("b: "), input("c: ")));
						break;
					case 8: 
						System.out.println("Result: " + m.max(input("a: "), input("b: "), input("c: "), input("d: ")));
						break;
					case 9:
						System.out.println("Result: " + m.max(inputArray("Enter integers separated by space: ")));
						break;
					case 10:
						System.out.println("Result: " + m.min(input("a: "), input("b: "), input("c: ")));
						break;
					case 11:
						System.out.println("Result: " + m.min(input("a: "), input("b: "), input("c: "), input("d: ")));
						break;
					case 12:
						System.out.println("Result: " + m.min(inputArray("Enter integers separated by space: ")));
						break;
					case 13:
						System.out.println("Result: " + m.average(input("a: "), input("b: "), input("c: ")));
						break;
					case 14:
						System.out.println("Result: " + m.average(input("a: "), input("b: "), input("c: "), input("d: ")));
						break;
					case 15:
						System.out.println("Result: " + m.average(inputArray("Enter integers separated by space: ")));
						break;
					case 16:
						System.out.println("Goodbye");
						return;
					default:
						System.out.println("Unknown choice");
				}
			} catch (Exception e) {
				System.out.println("Error: " + e.getMessage());
			}
		} while (choice != 8);
		scan.close();
	}
	static Scanner scan = new Scanner(System.in);
	static int input(String prompt) {
		System.out.print(prompt);
		return scan.nextInt();
	}
	static int[] inputArray(String prompt) {
		System.out.print(prompt);
		scan.nextLine();
		String line = scan.nextLine().trim();
		return parseArray(line);
	}
	static int[] parseArray(String line) {
		if (line.isEmpty())
			return new int[0];
		String[] seg = line.split("\\s+");
		int[] arr = new int[seg.length];
		for (int i = 0; i < seg.length; i++)
			arr[i] = Integer.parseInt(seg[i]);
		return arr;
	}
}