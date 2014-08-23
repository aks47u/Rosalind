package Python_Village;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class R004_INI4_Conditions_and_Loops {
	private static ArrayList<String> inData;

	public static void main(String[] args) throws IOException {
		loadFile(new File("rosalind_ini4.txt"));
		int lower = Integer.parseInt(inData.get(0).substring(0,
				inData.get(0).indexOf(" ")));
		int upper = Integer.parseInt(inData.get(0).substring(
				inData.get(0).indexOf(" ") + 1));
		int result = 0;

		for (int i = lower; i <= upper; i++) {
			result += (i % 2 == 1 ? i : 0);
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
