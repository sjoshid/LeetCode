package com.practice.bloomberg;

public class SearchInsert {
    public int searchInsert(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;

        if (target < nums[0]) {
            return 0;
        }
        if (target > nums[nums.length - 1]) {
            return nums.length;
        }

        while (l != r - 1) {
            int mid = l + (r - l) / 2;

            if (target < nums[mid]) {
                r = mid;
            } else if (target > nums[mid]) {
                l = mid;
            } else {
                return mid;
            }
        }

        if (nums[l] == target) {
            return l;
        }
        return r;
    }
}
