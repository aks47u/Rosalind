package Bioinformatics_Stronghold;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class CONS_Consensus_and_Profile {
	private static ArrayList<String> inData;

	public static void main(String[] args) throws IOException {
		loadFile(new File("rosalind_cons.txt"));
		String fasta = "", a = "A: ", c = "C: ", g = "G: ", t = "T: ";
		int dnaStrings = 0, strandNo = -1;

		for (int i = 0; i < inData.size(); i++) {
			if (inData.get(i).contains(">")) {
				dnaStrings++;
			}
		}

		String[] arr = new String[dnaStrings];

		for (int i = 0; i < dnaStrings; i++) {
			arr[i] = "";
		}

		for (int i = 0; i < inData.size(); i++) {
			if (!inData.get(i).contains(">")) {
				arr[strandNo] += inData.get(i);
			} else {
				strandNo++;
			}
		}

		int dnaLength = arr[0].length();
		int[][] profile = new int[dnaLength][4];

		for (int i = 0; i < dnaLength; i++) {
			profile[i][0] = 0;
			profile[i][1] = 0;
			profile[i][2] = 0;
			profile[i][3] = 0;
		}

		for (int i = 0; i < dnaStrings; i++) {
			for (int j = 0; j < dnaLength; j++) {
				switch (arr[i].charAt(j)) {
				case 'A':
					profile[j][0]++;
					break;
				case 'C':
					profile[j][1]++;
					break;
				case 'G':
					profile[j][2]++;
					break;
				case 'T':
					profile[j][3]++;
					break;
				default:
					break;
				}
			}
		}

		for (int i = 0; i < dnaLength; i++) {
			a += profile[i][0] + " ";
			c += profile[i][1] + " ";
			g += profile[i][2] + " ";
			t += profile[i][3] + " ";

			int max = Math.max(Math.max(profile[i][0], profile[i][1]),
					Math.max(profile[i][2], profile[i][3]));
			fasta += profile[i][0] == max ? "A" : profile[i][1] == max ? "C"
					: profile[i][2] == max ? "G" : "T";
		}

		System.out.println(fasta + "\n" + a + "\n" + c + "\n" + g + "\n" + t);
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
