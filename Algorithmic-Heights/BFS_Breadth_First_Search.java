package Algorithmic_Heights;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class BFS_Breadth_First_Search {
	private static ArrayList<String> inData;

	public static void main(String[] args) throws IOException {
		loadFile(new File("rosalind_bfs.txt"));
		String[] nodeEdge = inData.get(0).split(" ");
		int nodes = Integer.parseInt(nodeEdge[0]);
		ArrayList<ArrayList<Integer>> childList = new ArrayList<ArrayList<Integer>>();

		for (int i = 0; i <= nodes; i++) {
			ArrayList<Integer> child = new ArrayList<Integer>();
			childList.add(child);
		}

		for (int i = 1; i < inData.size(); i++) {
			String[] edgeLine = inData.get(i).split(" ");
			int from = Integer.parseInt(edgeLine[0]);
			int to = Integer.parseInt(edgeLine[1]);
			childList.get(from).add(to);
		}

		int[] result = new int[nodes + 1];

		for (int i = 0; i < result.length; i++) {
			result[i] = -1;
		}

		int current = 1, count = 1;
		result[1] = 0;
		ArrayList<Integer> child = childList.get(current);

		while (child.size() > 0) {
			ArrayList<Integer> grandChild = new ArrayList<Integer>();

			for (int i = 0; i < child.size(); i++) {
				int node = child.get(i);

				if (result[node] == -1) {
					result[node] = count;
				}

				ArrayList<Integer> gc = childList.get(node);

				for (int j = 0; j < gc.size(); j++) {
					if (result[gc.get(j)] == -1) {
						grandChild.add(gc.get(j));
					}
				}
			}

			child = grandChild;
			count++;
		}

		for (int i = 1; i < result.length; i++) {
			System.out.print(result[i] + " ");
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
