package Bioinformatics_Stronghold;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class IPRB_Mendels_First_Law {
	private static ArrayList<String> inData;

	public static void main(String[] args) throws IOException {
		loadFile(new File("rosalind_iprb.txt"));
		String[] arr = inData.get(0).split(" ");
		double k = Double.parseDouble(arr[0]);
		double m = Double.parseDouble(arr[1]);
		double n = Double.parseDouble(arr[2]);
		double T = k + m + n;
		double mf = (m / T)
				* (0.25 * ((m - 1) / (T - 1)) + (0.5 * (n / (T - 1))));
		double nf = (n / T) * (0.5 * (m / (T - 1)) + ((n - 1) / (T - 1)));
		System.out.println(1.0 - mf - nf);
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
