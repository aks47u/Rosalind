package Algorithmic_Heights;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class R004_INS_Insertion_Sort {
	private static ArrayList<String> inData;

	public static void main(String[] args) throws IOException {
		loadFile(new File("rosalind_ins.txt"));
		int n = Integer.parseInt(inData.get(0).trim());
		String[] a = inData.get(1).split(" ");
		int result = 0;

		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j < n; j++) {
				if (Integer.parseInt(a[i]) > Integer.parseInt(a[j])) {
					result++;
				}
			}
		}

		System.out.println(result);
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
