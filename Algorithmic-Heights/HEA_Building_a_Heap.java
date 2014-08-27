package Algorithmic_Heights;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class HEA_Building_a_Heap {
	private static ArrayList<String> inData;

	public static void main(String[] args) throws IOException {
		loadFile(new File("rosalind_hea.txt"));
		String[] arr = inData.get(1).split(" ");
		int[] data = new int[arr.length];

		for (int i = 0; i < arr.length; i++) {
			data[i] = Integer.parseInt(arr[i]);
		}

		Arrays.sort(data);

		for (int i = data.length - 1; i > -1; i--) {
			System.out.print(data[i] + " ");
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
