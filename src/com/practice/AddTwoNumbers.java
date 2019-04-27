package com.practice;

import java.util.HashMap;
import java.util.Map;

public class AddTwoNumbers {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> m = new HashMap<>();
        int first = 0, second = 0;

        for (int i = 0; i < nums.length; i++) {
            int n = nums[i];
            int diff = target - n;

            if (m.containsKey(diff)) {
                first = m.get(diff);
                second = i;
                break;
            } else {
                m.put(n, i);
            }
        }

        return new int[]{first, second};
    }
}
