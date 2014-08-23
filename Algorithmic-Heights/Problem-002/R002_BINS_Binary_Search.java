package Algorithmic_Heights;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class R002_BINS_Binary_Search {
	private static ArrayList<String> inData;

	public static void main(String[] args) throws IOException {
		loadFile(new File("rosalind_bins.txt"));
		int n = Integer.parseInt(inData.get(0).trim());
		int m = Integer.parseInt(inData.get(1).trim());
		int[] a = new int[n];
		String[] sorted = inData.get(2).split(" ");

		for (int i = 0; i < n; i++) {
			a[i] = Integer.parseInt(sorted[i].trim());
		}

		String[] find = inData.get(3).split(" ");

		for (int i = 0; i < m; i++) {
			int term = Integer.parseInt(find[i].trim());
			System.out.print(binarySearch(term, a, 0, a.length - 1) + " ");
		}
	}

	private static int binarySearch(int goal, int[] data, int left, int right) {
		if (left == right) {
			return data[left] == goal ? left + 1 : -1;
		}

		int mid = (left + right) / 2;

		return data[mid] >= goal ? binarySearch(goal, data, left, mid)
				: binarySearch(goal, data, mid + 1, right);
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
