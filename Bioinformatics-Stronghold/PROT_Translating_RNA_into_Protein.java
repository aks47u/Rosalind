package Bioinformatics_Stronghold;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class PROT_Translating_RNA_into_Protein {
	private static ArrayList<String> inData;

	public static void main(String[] args) throws IOException {
		loadFile(new File("rosalind_prot.txt"));
		inData.add(inData.get(0).replaceAll("T", "U"));
		String initial = "UUU,F:UUC,F:UUA,L:UUG,L:UCU,S:UCC,S:UCA,S:UCG,S:UAU,Y:UAC,Y:UAA,Stop:UAG,Stop:UGU,C:UGC,C:UGA,Stop:UGG,W:CUU,L:CUC,L:CUA,L:CUG,L:CCU,P:CCC,P:CCA,P:CCG,P:CAU,H:CAC,H:CAA,Q:CAG,Q:CGU,R:CGC,R:CGA,R:CGG,R:AUU,I:AUC,I:AUA,I:AUG,M:ACU,T:ACC,T:ACA,T:ACG,T:AAU,N:AAC,N:AAA,K:AAG,K:AGU,S:AGC,S:AGA,R:AGG,R:GUU,V:GUC,V:GUA,V:GUG,V:GCU,A:GCC,A:GCA,A:GCG,A:GAU,D:GAC,D:GAA,E:GAG,E:GGU,G:GGC,G:GGA,G:GGG,G";
		String[] partial = initial.split(":");
		String[][] table = new String[partial.length][2];
		String result = "";

		for (int i = 0; i < partial.length; i++) {
			table[i][0] = partial[i].substring(0, partial[i].indexOf(','));
			table[i][1] = partial[i].substring(partial[i].indexOf(',') + 1);
		}

		for (int i = 0; i < inData.get(1).length() - 3; i += 3) {
			for (int j = 0; j < partial.length; j++) {
				if (inData.get(1).substring(i, i + 3).equals(table[j][0])) {
					result += table[j][1];
				}
			}
		}

		System.out.println(result);
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
