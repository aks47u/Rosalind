package Bioinformatics_Armory;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;

public class GBK_GenBank_Introduction {
	private static ArrayList<String> inData, webData;

	public static void main(String[] args) throws IOException {
		loadFile(new File("rosalind_gbk.txt"));
		scrape("http://www.ncbi.nlm.nih.gov/nuccore?term=%28" + inData.get(0)
				+ "[Title]%29%20AND%20%28%22"
				+ inData.get(1).replace("/", "%2F")
				+ "%22[Publication%20Date]%20%3A%20%22"
				+ inData.get(2).replace("/", "%2F")
				+ "%22[Publication%20Date]%29");

		for (int i = 0; i < webData.size(); i++) {
			for (int j = 0; j < webData.get(i).length() - 9; j++) {
				if (webData.get(i).substring(j, j + 9).equals("Results: ")) {
					for (int k = j + 9; k < webData.get(i).length(); k++) {
						if (webData.get(i).charAt(k) != '<') {
							System.out.print(webData.get(i).charAt(k));
						} else {
							break;
						}
					}
				}
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
