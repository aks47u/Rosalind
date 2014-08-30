package Bioinformatics_Stronghold;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class FIB_Rabbits_and_Recurrence_Relations {
	private static ArrayList<String> inData;

	public static void main(String[] args) throws IOException {
		loadFile(new File("rosalind_fib.txt"));
		int time = Integer.parseInt(inData.get(0).substring(0,
				inData.get(0).indexOf(' ')));
		int rate = Integer.parseInt(inData.get(0).substring(
				inData.get(0).indexOf(' ') + 1));
		long[] rabbits = new long[time];

		for (int i = 0; i < time; i++) {
			if (i == 0 || i == 1) {
				rabbits[i] = 1;
			} else {
				rabbits[i] = rabbits[i - 1] + rate * rabbits[i - 2];
			}
		}

		System.out.println(rabbits[time - 1]);
	}

	private static void loadFile(File aFile) throws IOException {
		BufferedReader input = new BufferedReader(new FileReader(aFile));
		String line = null;
		inData = new ArrayList<String>();

		while ((line = input.readLine()) != null) {
			inData.add(line);
		}

		input.close();
	}
}
