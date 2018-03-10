package com.practice;

import java.util.Arrays;

/**
 * I couldnt finish this. :(
 */
public class NumberOfSubarraysWithBoudedMax {
    int count = 0;

    public int numSubarrayBoundedMax(int[] A, int L, int R) {
        countSubarrays(A, L, R, count);
        return count;
    }

    public boolean countSubarrays(int[] A, int L, int R, int count) {
        if(A.length > 1) {
            int element = A[0];
            if (element >= L && element <= R) {
                count++;
                int[] newA = Arrays.copyOfRange(A, 1, A.length - 1);
                if(countSubarrays(newA, L, R, count)) {
                    count++;
                }
            } else {
                return false;
            }
        }
        return true;
    }
}
