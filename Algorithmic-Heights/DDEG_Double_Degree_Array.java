package Algorithmic_Heights;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class DDEG_Double_Degree_Array {
	private static ArrayList<String> inData;

	public static void main(String[] args) throws IOException {
		loadFile(new File("rosalind_ddeg.txt"));
		int vertices = Integer.parseInt(inData.get(0).substring(0,
				inData.get(0).indexOf(" ")));
		int edges = Integer.parseInt(inData.get(0).substring(
				inData.get(0).indexOf(" ") + 1));
		int[] leftEdge = new int[edges];
		int[] rightEdge = new int[edges];

		for (int i = 0; i < edges; i++) {
			leftEdge[i] = Integer.parseInt(inData.get(i + 1).substring(0,
					inData.get(i + 1).indexOf(" ")));
			rightEdge[i] = Integer.parseInt(inData.get(i + 1).substring(
					inData.get(i + 1).indexOf(" ") + 1));
		}

		int[] degreeArray = new int[vertices];

		for (Integer vertex : leftEdge) {
			degreeArray[vertex - 1]++;
		}

		for (Integer vertex : rightEdge) {
			degreeArray[vertex - 1]++;
		}

		int[] sumArray = new int[vertices];

		for (int i = 0; i < edges; i++) {
			sumArray[leftEdge[i] - 1] += degreeArray[rightEdge[i] - 1];
			sumArray[rightEdge[i] - 1] += degreeArray[leftEdge[i] - 1];
		}

		for (Integer sum : sumArray) {
			System.out.print(sum + " ");
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
