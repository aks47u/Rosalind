package Bioinformatics_Stronghold;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class REVC_Complementing_a_Strand_of_DNA {
	private static ArrayList<String> inData;

	public static void main(String[] args) throws IOException {
		loadFile(new File("rosalind_revc.txt"));
		String result = inData.get(0);
		result = result.replaceAll("A", "W");
		result = result.replaceAll("C", "X");
		result = result.replaceAll("G", "Y");
		result = result.replaceAll("T", "Z");
		result = result.replaceAll("W", "T");
		result = result.replaceAll("X", "G");
		result = result.replaceAll("Y", "C");
		result = result.replaceAll("Z", "A");

		for (int i = result.length() - 1; i > -1; i--) {
			System.out.print(result.charAt(i));
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
