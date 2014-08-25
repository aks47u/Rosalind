package Python_Village;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class R002_INI2_Variables_and_Some_Arithmetic {
	private static ArrayList<String> inData;

	public static void main(String[] args) throws IOException {
		loadFile(new File("rosalind_ini2.txt"));
		int num1 = Integer.parseInt(inData.get(0).substring(0,
				inData.get(0).indexOf(" ")));
		int num2 = Integer.parseInt(inData.get(0).substring(
				inData.get(0).indexOf(" ") + 1));
		int result = (num1 * num1) + (num2 * num2);
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
