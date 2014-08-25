package Python_Village;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class INI6_Dictionaries {
	private static ArrayList<String> inData;

	public static void main(String[] args) throws IOException {
		loadFile(new File("rosalind_ini6.txt"));
		String[] arr = inData.get(0).split(" ");
		ArrayList<String> data = new ArrayList<String>();
		int[] count = new int[arr.length];

		for (int i = 0; i < arr.length; i++) {
			count[i] = 0;

			if (!data.contains(arr[i])) {
				data.add(arr[i]);
				count[data.indexOf(arr[i])]++;
			} else {
				count[data.indexOf(arr[i])]++;
			}
		}

		for (int i = 0; i < arr.length; i++) {
			if (count[i] != 0) {
				System.out.println(data.get(i) + " " + count[i]);
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
