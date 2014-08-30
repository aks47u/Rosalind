package Bioinformatics_Stronghold;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class GC_Computing_GC_Content {
	private static ArrayList<String> inData;

	public static void main(String[] args) throws IOException {
		loadFile(new File("rosalind_gc.txt"));
		String maxName = "", tempName = "", tempDNA = "";
		double maxGC = 0.0, tempGC = 0.0;

		for (int i = 0; i < inData.size(); i++) {
			String temp = inData.get(i);

			if (temp.length() == 0) {
				break;
			}

			if (temp.charAt(0) == '>') {
				tempGC = gc(tempDNA);

				if (tempGC > maxGC) {
					maxName = tempName;
					maxGC = tempGC;
				}

				tempName = temp.substring(1);
				tempDNA = "";
			} else {
				tempDNA += temp;
			}
		}

		tempGC = gc(tempDNA);

		if (tempGC > maxGC) {
			maxName = tempName;
			maxGC = tempGC;
		}

		System.out.println(maxName);
		System.out.println(maxGC);
	}

	private static double gc(String s) {
		int gc = 0;

		if (s.length() == 0) {
			return 0.0;
		}

		for (char c : s.toCharArray()) {
			switch (c) {
			case 'C':
				gc++;
				break;
			case 'G':
				gc++;
				break;
			}
		}

		return 100.0 * gc / s.length();
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
