package Bioinformatics_Armory;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class INI_Introduction_to_the_Bioinformatics_Armory {
	private static ArrayList<String> inData;

	public static void main(String[] args) throws IOException {
		loadFile(new File("rosalind_ini.txt"));
		int a = 0, c = 0, g = 0, t = 0;

		for (int i = 0; i < inData.get(0).length(); i++) {
			switch (inData.get(0).charAt(i)) {
			case 'A':
				a++;
				break;
			case 'C':
				c++;
				break;
			case 'G':
				g++;
				break;
			case 'T':
				t++;
				break;
			default:
				break;
			}
		}

		System.out.println(a + " " + c + " " + g + " " + t);
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
