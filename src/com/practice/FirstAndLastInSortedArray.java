package com.practice;

public class FirstAndLastInSortedArray {
    public int[] searchRange(int[] nums, int target) {

        int start = 0;
        int end = nums.length - 1;

        while (end > start) {
            int midInd = (end - start) / 2;
            int mid = nums[midInd];

            if (mid < target) {
                start = midInd;
            } else if (mid > target) {
                end = midInd;
            } else {
                int l = midInd;
                int r = midInd;

            }
        }
    }
}
