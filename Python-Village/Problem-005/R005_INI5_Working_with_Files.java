package Python_Village;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class R005_INI5_Working_with_Files {
	private static ArrayList<String> inData;

	public static void main(String[] args) throws IOException {
		loadFile(new File("rosalind_ini5.txt"));
		
		for (int i = 0; i < inData.size(); i++) {
			if (i % 2 == 1) {
				System.out.println(inData.get(i));
			}
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
