package Bioinformatics_Armory;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;

public class DBPR_Introduction_to_Protein_Databases {
	private static ArrayList<String> inData, webData;

	public static void main(String[] args) throws IOException {
		loadFile(new File("rosalind_dbpr.txt"));
		scrape("http://www.uniprot.org/uniprot/" + inData.get(0));
		String data = "";
		int start = 0, count = 0, end = 0;

		for (int i = 0; i < webData.size(); i++) {
			if (webData.get(i).contains("Gene Ontology (GO)")) {
				data = webData.get(i);
				break;
			}
		}

		for (int i = 0; i < data.length() - 18; i++) {
			if (data.substring(i, i + 18).equals("Gene Ontology (GO)")) {
				start = i;

				for (int j = i + 18; j < data.length() - 25; j++) {
					if (data.substring(j, j + 25).equals(
							"<td class=\"first-column\">")) {
						count++;

						if (count == 2) {
							end = j;
							break;
						}
					}
				}
			}
		}

		boolean print = false;
		ArrayList<String> d = new ArrayList<String>();
		String ans = "";

		for (int i = start; i < end; i++) {
			if (data.substring(i, i + 21).equals("'Display-GO-Term');\">")) {
				print = true;
				ans = "";
			}

			if (data.substring(i, i + 2).equals("</")) {
				d.add(ans);
				print = false;
			}

			if (print) {
				ans += data.charAt(i + 21);
			}
		}

		for (int i = 1; i < d.size(); i++) {
			if (!d.get(i).equals(d.get(i - 1))) {
				System.out.println(d.get(i)
						.substring(0, d.get(i).length() - 21));
			}
		}
	}

	private static void scrape(String website) {
		try {
			BufferedReader scanner = new BufferedReader(new InputStreamReader(
					new URL(website).openConnection().getInputStream()));
			String input = null;
			webData = new ArrayList<String>();

			while ((input = scanner.readLine()) != null) {
				webData.add(input);
			}

			scanner.close();
		} catch (IOException error) {
			System.err.println("error connecting to server.");
			error.printStackTrace();
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
