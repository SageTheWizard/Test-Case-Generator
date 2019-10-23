import java.io.*;
import java.util.*;
public class testCases {
	public static void main(String[] args) throws IOException {
		int n = 0;
		if (args.length != 2) {
			System.err.println("Format Error: Usage: \"java testCases n [gl | ps | rn | dp | bn | ln]\" ");
			System.err.println("Key: \n  gl: Greatest to Least (reverse order) \n  ps: Pre-Sorted \n  rn: Random \n  dp: Allow Dupes \n  bn: Big Numbers (only numbers with a high amount of digits) \n  ln: Little Numbers (only numbers with a single digit \n  n: Input size");
		}
		else
		{
			if (isDigit(args[0]))
				n = Integer.parseInt(args[0]);
			else {
				System.err.println("Error: First argument must be an integer!");
				System.exit(0);
			}
			
			switch(args[1]) {
				case "gl":
					generateGL(n);
					break;
				case "ps":
					generatePS(n);
					break;
				case "dp":
					generateDP(n);
					break;
				case "rn":
					generateRN(n);
					break;
				case "bn":
					generateBN(n);
					break;
				case "ln":
					generateLN(n);
					break;
				default:
					System.out.println("Error: Invalid Settings");
					System.exit(0);
			}

			System.out.println("File Created: [testcase-" + n + "-" + args[1] + ".txt]");
		}
	}
	public static boolean isDigit(String arg0) {
		return arg0.matches("\\d+");
	}
	public static void generateLN(int n) throws IOException {
		int alpha = 65;
		BufferedWriter writer = new BufferedWriter(new FileWriter("testcase-" + n + "-ln.txt", true));
		writer.append(n + "\n");
		for (int i = 0; i < n; i++){
			writer.append((int) (Math.random() * 10) + " " + (char) alpha + "\n");
			alpha++;
			if (alpha == 91)
				alpha = 65;
		}
		writer.close();
	}
	public static void generateBN(int n) throws IOException {
		int alpha = 65;
		BufferedWriter writer = new BufferedWriter(new FileWriter("testcase-" + n + "-bn.txt", true));
		writer.append(n + "\n");
		for (int i = 0; i < n; i++) {
			writer.append((int) ((Math.random() * (100000000 - 10000000)) + 10000000) + " " + (char) alpha + "\n");
			alpha++;
			if (alpha == 91)
				alpha = 65;
		}
		writer.close();
	}

	public static void generateGL(int n) throws IOException {
		int alpha = 65;
		BufferedWriter writer = new BufferedWriter(new FileWriter("testcase-" + n + "-gl.txt", true));
		writer.append(n + "\n");
		for (int i = (n - 1); i >= 0; i--) {
				writer.append(i + " " + (char) alpha + "\n");
				alpha++;
				if (alpha == 91)
					alpha = 65;
		}
		writer.close();

		
	}
	public static void generatePS(int n) throws IOException {
		int alpha = 65;
		BufferedWriter writer = new BufferedWriter(new FileWriter("testcase-" + n + "-ps.txt", true));
		writer.append(n + "\n");
		for (int i = 0; i < n; i++) {
			writer.append(i + " " + (char) alpha + "\n");
			alpha++;
			if (alpha == 91)
				alpha = 65;
		}
		writer.close();
	}
	public static void generateDP(int n) throws IOException {
		int alpha = 65;
		BufferedWriter writer = new BufferedWriter(new FileWriter("testcase-" + n + "-dp.txt", true));
		writer.append(n + "\n");
		for (int i = 0; i < n; i++) {
			writer.append((int) (Math.random()*(n - 2)) + " " + (char) alpha + "\n");
			alpha++;
			if (alpha == 91)
				alpha = 65;
		}
		writer.close();
	}
	public static void generateRN(int n) throws IOException {
		int alpha = 65;
		BufferedWriter writer = new BufferedWriter(new FileWriter("testcase-" + n + "-rn.txt", true));
		writer.append(n + "\n");
		for (int i = 0; i < n; i++) {
			writer.append((int) (Math.random() * (Integer.MAX_VALUE / 1000)) + " " + (char) alpha + "\n");
			alpha++;
			if (alpha == 91)
				alpha = 65;
		}
		writer.close();
	}

}
