package com.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * https://leetcode.com/problems/permutations/
 */
public class Permute {
	public List<List<Integer>> permute(int[] nums) {
		List<List<Integer>> list = new ArrayList<>();
		combinations(nums, 0, list);
		return list;
	}

	public void combinations(int [] nums, int index, List<List<Integer>> list) {
		List<Integer> combination = Arrays.stream(nums).boxed().collect(Collectors.toList());
		list.add(combination);
		for (int j = index; j < nums.length - 1; j++) {
			for (int i = j+1; i < nums.length; i++) {
				int[] copy = Arrays.copyOf(nums, nums.length);
				swap(nums, j, i);
				combinations(nums, j+1, list);
				swap(nums, j, i);
			}
		}
	}

	public void swap(int[] nums, int f, int s) {
		int d = nums[f];
		nums[f] = nums[s];
		nums[s] = d;
	}

	public static void main(String[] args) {
		Permute permute = new Permute();
		permute.permute(new int[]{1,2,3});
	}
}
