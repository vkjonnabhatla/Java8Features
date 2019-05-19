package org.code.challenge;

import java.util.ArrayList;

public class Subsets {

	public static void main(String[] args) {
		int[] arr = new int[] { 1, 2, 3};
		System.out.println(subsets(arr, 0, new ArrayList<Integer>(), new ArrayList<ArrayList<Integer>>()));
	}

	public static ArrayList<ArrayList<Integer>> subsets(int[] input, int startIndex, ArrayList<Integer> subset,
			ArrayList<ArrayList<Integer>> result) {
		result.add(new ArrayList<>(subset));
		for (int i = startIndex; i < input.length; i++) {
			subset.add(input[i]);
			subsets(input, i + 1, subset, result);
			subset.remove(subset.size() - 1);
		}
		return result;
	}
}
