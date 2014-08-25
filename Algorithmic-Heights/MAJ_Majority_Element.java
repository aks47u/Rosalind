package Algorithmic_Heights;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MAJ_Majority_Element {
	private static ArrayList<String> inData;

	public static void main(String[] args) throws IOException {
		loadFile(new File("rosalind_maj.txt"));
		int rows = Integer.parseInt(inData.get(0).substring(0,
				inData.get(0).indexOf(" ")));

		for (int i = 0; i < rows; i++) {
			List<Integer> array = new ArrayList<Integer>();
			String[] arr = inData.get(i + 1).split(" ");

			for (int j = 0; j < arr.length; j++) {
				array.add(Integer.parseInt(arr[j]));
			}
			System.out.print(majorityElement(array) + " ");
		}
	}

	private static int majorityElement(List<Integer> array) {
		int candidate = 0, count = 0;

		for (Integer element : array) {
			if (count == 0) {
				candidate = element;
			}

			if (candidate == element) {
				count++;
			} else {
				count--;
			}
		}

		count = 0;

		for (Integer element : array) {
			if (element == candidate) {
				count++;
			}
		}

		return count > array.size() / 2 ? candidate : -1;
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
