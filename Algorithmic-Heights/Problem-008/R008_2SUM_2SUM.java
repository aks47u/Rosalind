package Algorithmic_Heights;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class R008_2SUM_2SUM {
	private static ArrayList<String> inData;

	public static void main(String[] args) throws IOException {
		loadFile(new File("rosalind_2sum.txt"));

		for (int i = 1; i < inData.size(); i++) {
			System.out.println(twoSum(inData.get(i).split(" ")));
		}
	}

	private static String twoSum(String[] numbers) {
		String ret = "";

		for (int i = 0; i < numbers.length; i++) {
			for (int j = i + 1; j < numbers.length; j++) {
				if (Integer.parseInt(numbers[i]) + Integer.parseInt(numbers[j]) == 0) {
					ret = "" + (i + 1);
					ret += " " + (j + 1);
				}
			}
		}

		return ret.length() > 0 ? ret : "-1";
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
