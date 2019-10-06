package com.practice;

import java.util.*;

/**
 * https://leetcode.com/problems/combination-sum/
 */
public class CombinationSum {
	List<List<Integer>> seqs = new ArrayList<>();

	public List<List<Integer>> combinationSum(int[] candidates, int target) {
		Arrays.sort(candidates);
		a(candidates, new LinkedList<>(), 0, 0, target);
		return seqs;
	}

	public void a(int[] sortedCandidates, Deque<Integer> d, int index, int sum, int target) {
		for (int i = index; i < sortedCandidates.length; i++) {
			int temp = sum + sortedCandidates[i];
			if (temp > target) {
				return;
			} else if (temp == target) {
				//found sequence
				List<Integer> seq = new ArrayList<>(d);
				seq.add(sortedCandidates[i]);
				seqs.add(seq);
				return;
			} else {
				sum = temp;
				d.add(sortedCandidates[i]);
				a(sortedCandidates, d, i, sum, target);
				d.removeLast();
				sum -= sortedCandidates[i];
			}
		}
	}

	public static void main(String[] args) {
		CombinationSum cs = new CombinationSum();
		int [] arr = new int[]{1,3};
		cs.combinationSum(arr, 6);
	}
}
