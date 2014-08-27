package Algorithmic_Heights;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class PAR_2_Way_Partition {
	private static ArrayList<String> inData;

	public static void main(String[] args) throws IOException {
		loadFile(new File("rosalind_par.txt"));
		String[] arr = inData.get(1).split(" ");
		int[] nums = new int[arr.length];

		for (int i = 0; i < arr.length; i++) {
			nums[i] = Integer.parseInt(arr[i]);
		}

		twoWay twpar = new twoWay(nums);
		twpar.partitionIt2();

		for (int i = 0; i < nums.length; i++) {
			System.out.print(nums[i] + " ");
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

class twoWay {
	private int[] nums;

	public twoWay(int[] vec) {
		nums = vec;
	}

	public int partitionIt(int leftPtr, int rightPtr) {
		int pivorPtr = leftPtr;
		int pivor = nums[pivorPtr];

		while (true) {
			while (leftPtr <= rightPtr && nums[leftPtr] <= pivor) {
				leftPtr++;
			}

			while (rightPtr >= leftPtr && nums[rightPtr] > pivor) {
				rightPtr--;
			}

			if (leftPtr < rightPtr) {
				swap(leftPtr, rightPtr);
			} else {
				break;
			}
		}

		swap(pivorPtr, rightPtr);

		return rightPtr;
	}

	public void partitionIt2() {
		partitionIt(0, nums.length - 1);
	}

	public void swap(int i, int j) {
		int tmp = nums[i];
		nums[i] = nums[j];
		nums[j] = tmp;
	}
}
