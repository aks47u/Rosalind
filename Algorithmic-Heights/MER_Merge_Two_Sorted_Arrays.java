package Algorithmic_Heights;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MER_Merge_Two_Sorted_Arrays {
	private static ArrayList<String> inData;

	public static void main(String[] args) throws IOException {
		loadFile(new File("rosalind_mer.txt"));
		List<Integer> first = new ArrayList<Integer>();
		String[] arr = inData.get(1).split(" ");

		for (int i = 0; i < arr.length; i++) {
			first.add(Integer.parseInt(arr[i]));
		}

		List<Integer> second = new ArrayList<Integer>();
		arr = inData.get(3).split(" ");

		for (int i = 0; i < arr.length; i++) {
			second.add(Integer.parseInt(arr[i]));
		}

		while (!first.isEmpty() || !second.isEmpty()) {
			System.out.print(merge(first, second) + " ");
		}
	}

	private static int merge(List<Integer> first, List<Integer> second) {
		if (!first.isEmpty()) {
			int element1 = first.remove(0);

			if (!second.isEmpty()) {
				int element2 = second.remove(0);

				if (element1 < element2) {
					second.add(0, element2);

					return element1;
				} else {
					first.add(0, element1);

					return element2;
				}
			} else {
				return element1;
			}
		} else {
			return second.remove(0);
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
