package Algorithmic_Heights;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FIBO_Fibonacci_Numbers {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner scn = new Scanner(new File("rosalind_fibo.txt"));
		int term = Integer.parseInt(scn.nextLine().trim());
		scn.close();

		int fib1 = 0, fib2 = 1, result = 0;

		for (int i = 0; i < term - 1; i++) {
			result = fib1 + fib2;
			fib2 += fib1;
			fib1 = fib2 - fib1;
		}

		System.out.println(result);
	}
}
