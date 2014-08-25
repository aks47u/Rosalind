package Python_Village;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class INI3_Strings_and_Lists {
	private static ArrayList<String> inData;

	public static void main(String[] args) throws IOException {
		loadFile(new File("rosalind_ini3.txt"));
		String[] arr = inData.get(1).split(" ");
		System.out.println(inData.get(0).substring(Integer.parseInt(arr[0]),
				Integer.parseInt(arr[1]) + 1)
				+ " "
				+ inData.get(0).substring(Integer.parseInt(arr[2]),
						Integer.parseInt(arr[3]) + 1));
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
