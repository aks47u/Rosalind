package Algorithmic_Heights;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class R003_DEG_Degree_Array {
	private static ArrayList<String> inData;

	public static void main(String[] args) throws IOException {
		loadFile(new File("rosalind_deg.txt"));
		int vertices = Integer.parseInt(inData.get(0).substring(0,
				inData.get(0).indexOf(" ")));
		List<Integer> leftEdge = new ArrayList<>();
		List<Integer> rightEdge = new ArrayList<>();

		for (int i = 1; i < inData.size(); i++) {
			int vertex = Integer.parseInt(inData.get(i).substring(0,
					inData.get(i).indexOf(" ")));
			leftEdge.add(vertex);
			vertex = Integer.parseInt(inData.get(i).substring(
					inData.get(i).indexOf(" ") + 1));
			rightEdge.add(vertex);
		}

		int[] connections = new int[vertices];

		for (Integer vertex : leftEdge) {
			connections[vertex - 1]++;
		}

		for (Integer vertex : rightEdge) {
			connections[vertex - 1]++;
		}

		for (int vertex = 0; vertex < vertices; vertex++) {
			System.out.print(connections[vertex] + " ");
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
