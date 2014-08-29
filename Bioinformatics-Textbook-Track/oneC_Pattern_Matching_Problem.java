package Bioinformatics_Textbook_Track;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class oneC_Pattern_Matching_Problem {
	private static ArrayList<String> inData;

	public static void main(String[] args) throws IOException {
		loadFile(new File("rosalind_1c.txt"));
		String search = inData.get(1), find = inData.get(0), ans = "";
		int findl = find.length();

		for (int i = 0; i < search.length() - findl; i++) {
			if (search.substring(i, i + findl).equals(find)) {
				ans += (i + " ");
			}
		}
		
		System.out.println(ans);
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
