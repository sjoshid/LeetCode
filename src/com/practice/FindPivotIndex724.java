package com.practice;

public class FindPivotIndex724 {

    public static void main(String[] args) {
        FindPivotIndex724 p = new FindPivotIndex724();
        System.out.println(p.pivotIndex(new int[]{-1, -1, 1, 1, 0, 0}));
    }

    public int pivotIndex1(int[] nums) {
        int i = 0, j = nums.length - 1;
        int lsum = nums[i];
        int rsum = nums[j];

        while (i < j) {
            if (lsum < rsum) {
                i++;
                lsum = lsum + nums[i];
            } else if (rsum < lsum) {
                j--;
                rsum = rsum + nums[j];
            } else {
                i++;
                j--;
            }

            if (lsum == rsum) {
                int l = i + 1;
                int r = j - 1;
                if (l == r)
                    return l;
            }
        }

        return -1;
    }

    public int pivotIndex(int[] nums) {

        if (nums.length == 0) {
            return -1;
        }

        int sum = 0;

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        boolean leftMost = false, rightMost = false;
        int leftMostPivot = sum - nums[0];
        if (leftMostPivot == 0) {
            leftMost = true;
        }

        int rightMostPivot = sum - nums[nums.length - 1];
        if (rightMostPivot == 0) {
            rightMost = true;
        }

        int csum = 0;
        int result = -1;
        for (int i = 0; i < nums.length - 2; i++) {
            csum += nums[i];
            int next = nums[i + 1];
            int check = sum - csum - next;

            if (csum == check) {
                result = ++i;
                break;
            }
        }

        if (leftMost)
            return 0;

        if (result != -1) {
            return result;
        }

        if (rightMost)
            return nums.length - 1;

        return -1;
    }

}
