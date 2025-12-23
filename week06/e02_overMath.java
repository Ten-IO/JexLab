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
	public int sum(int a, int b) {
		return a + b;
	}

	public int sum(int a, int b, int c) {
		return a + b + c;
	}

	public int sum(int[] values) {
		if (values == null) return 0;
		int s = 0;
		for (int v : values) s += v;
		return s;
	}

	// MULTIPLY
	public int multiply(int a, int b) {
		return a * b;
	}

	public int multiply(int a, int b, int c) {
		return a * b * c;
	}

	public int multiply(int[] values) {
		if (values == null) return 0;
		if (values.length == 0) return 0;
		int p = 1;
		for (int v : values) p *= v;
		return p;
	}

	// MAX
	public int max(int a, int b, int c) {
		int m = a;
		if (b > m) m = b;
		if (c > m) m = c;
		return m;
	}

	public int max(int a, int b, int c, int d) {
		int m = max(a, b, c);
		if (d > m) m = d;
		return m;
	}

	public int max(int[] values) {
		if (values == null || values.length == 0)
			throw new IllegalArgumentException("values must be non-empty");
		int m = values[0];
		for (int v : values) if (v > m) m = v;
		return m;
	}

	// MIN
	public int min(int a, int b, int c) {
		int m = a;
		if (b < m) m = b;
		if (c < m) m = c;
		return m;
	}

	public int min(int a, int b, int c, int d) {
		int m = min(a, b, c);
		if (d < m) m = d;
		return m;
	}

	public int min(int[] values) {
		if (values == null || values.length == 0)
			throw new IllegalArgumentException("values must be non-empty");
		int m = values[0];
		for (int v : values) if (v < m) m = v;
		return m;
	}

	// AVERAGE
	public double average(int a, int b, int c) {
		return (a + b + c) / 3.0;
	}

	public double average(int a, int b, int c, int d) {
		return (a + b + c + d) / 4.0;
	}

	public double average(int[] values) {
		if (values == null || values.length == 0)
			throw new IllegalArgumentException("values must be non-empty");
		return sum(values) / (double) values.length;
	}

	// simple demo and menu (CLI only)
	public static void main(String[] args) {
		e02_overMath m = new e02_overMath();
		Scanner scan = new Scanner(System.in);
		int choice;
		do {
			System.out.println("=== e02_overMath Menu ===");
			System.out.println("1. sum(a,b)");
			System.out.println("2. sum(a,b,c)");
			System.out.println("3. sum(array)");
			System.out.println("4. multiply(a,b)");
			System.out.println("5. max(array)");
			System.out.println("6. min(array)");
			System.out.println("7. average(array)");
			System.out.println("8. Exit");
			System.out.print("Enter choice: ");
			choice = scan.nextInt();
			switch (choice) {
				case 1: {
					System.out.print("a: "); int a = scan.nextInt();
					System.out.print("b: "); int b = scan.nextInt();
					System.out.println("Result: " + m.sum(a,b));
					break;
				}
				case 2: {
					System.out.print("a: "); int a = scan.nextInt();
					System.out.print("b: "); int b = scan.nextInt();
					System.out.print("c: "); int c = scan.nextInt();
					System.out.println("Result: " + m.sum(a,b,c));
					break;
				}
				case 3: {
					System.out.println("Enter integers separated by space (one line):");
					scan.nextLine();
					String line = scan.nextLine().trim();
					int[] arr = parseArray(line);
					System.out.println("Result: " + m.sum(arr));
					break;
				}
				case 4: {
					System.out.print("a: "); int a = scan.nextInt();
					System.out.print("b: "); int b = scan.nextInt();
					System.out.println("Result: " + m.multiply(a,b));
					break;
				}
				case 5: {
					System.out.println("Enter integers separated by space (one line):");
					scan.nextLine();
					String line = scan.nextLine().trim();
					int[] arr = parseArray(line);
					System.out.println("Result: " + m.max(arr));
					break;
				}
				case 6: {
					System.out.println("Enter integers separated by space (one line):");
					scan.nextLine();
					String line = scan.nextLine().trim();
					int[] arr = parseArray(line);
					System.out.println("Result: " + m.min(arr));
					break;
				}
				case 7: {
					System.out.println("Enter integers separated by space (one line):");
					scan.nextLine();
					String line = scan.nextLine().trim();
					int[] arr = parseArray(line);
					System.out.println("Result: " + m.average(arr));
					break;
				}
				case 8:
					System.out.println("Goodbye");
					break;
				default:
					System.out.println("Unknown choice");
			}
		} while (choice != 8);
		scan.close();
	}

	private static int[] parseArray(String line) {
		if (line.isEmpty()) return new int[0];
		String[] parts = line.split("\\s+");
		int[] arr = new int[parts.length];
		for (int i = 0; i < parts.length; i++) arr[i] = Integer.parseInt(parts[i]);
		return arr;
	}
}