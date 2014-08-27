package Algorithmic_Heights;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class threeSUM_3SUM {
	private static ArrayList<String> inData;

	public static void main(String[] args) throws IOException {
		loadFile(new File("rosalind_3sum.txt"));

		for (int i = 1; i < inData.size(); i++) {
			String[] arr = inData.get(i).split(" ");
			int[] data = new int[arr.length];

			for (int j = 0; j < arr.length; j++) {
				data[j] = Integer.parseInt(arr[j]);
			}

			System.out.println(threeSum(data));
		}
	}

	private static String threeSum(int[] num) {
		int[] numn = new int[num.length];
		String result = "-1";

		for (int i = 0; i < num.length; i++) {
			numn[i] = num[i];
		}

		Arrays.sort(num);

		for (int i = 0; i < num.length - 3; i++) {
			int a = num[i];
			int j = i + 1;
			int k = num.length - 1;

			while (j < k) {
				int b = num[j];
				int c = num[k];

				if (a + b + c == 0) {
					result = "";

					for (int l = 0; l < num.length; l++) {
						if (numn[l] == a) {
							result += " " + (l + 1) + " ";
							a = Integer.MAX_VALUE;
						}
						if (numn[l] == b) {
							result += " " + (l + 1) + " ";
							b = Integer.MAX_VALUE;
						}
						if (numn[l] == c) {
							result += " " + (l + 1) + " ";
							c = Integer.MAX_VALUE;
						}
					}

					return result.replace("  ", " ").trim();
				} else if (a + b + c > 0) {
					k--;
				} else {
					j++;
				}
			}
		}

		return "-1";
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
