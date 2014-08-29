package Bioinformatics_Textbook_Track;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class oneA_Frequent_Words_Problem {
	private static ArrayList<String> inData;

	public static void main(String[] args) throws IOException {
		loadFile(new File("rosalind_1a.txt"));
		String dnaStr = inData.get(0);
		int k = Integer.parseInt(inData.get(1));
		List<String> listPatterns = new ArrayList<String>();
		int curMaxCount = 0, tmpCount, lastInd;

		for (int i = 0; i < dnaStr.length() - k; i++) {
			String pattern = dnaStr.substring(i, i + k);
			tmpCount = 0;
			lastInd = -1;

			while (-1 != (lastInd = dnaStr.indexOf(pattern, lastInd + 1))) {
				tmpCount++;
			}

			if (tmpCount > curMaxCount) {
				curMaxCount = tmpCount;
				listPatterns.clear();
				listPatterns.add(pattern);
			} else if (tmpCount == curMaxCount) {
				listPatterns.add(pattern);
			}
		}

		Set<String> setItems = new LinkedHashSet<String>(listPatterns);
		listPatterns.clear();
		listPatterns.addAll(setItems);

		for (String pattern : listPatterns) {
			System.out.println(pattern + " ");
		}
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
