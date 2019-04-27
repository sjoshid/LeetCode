package com.practice;

import java.util.Arrays;

public class SquareNonDecreasing {
    public int[] sortedSquares(int[] A) {
        int[] sqs = new int[A.length];

        for (int i = 0; i < A.length; i++) {
            int sq = A[i] * A[i];
            sqs[i] = sq;
        }

        Arrays.sort(sqs);
        return sqs;
    }

    public static void main(String[] args) {
        SquareNonDecreasing s = new SquareNonDecreasing();
        int a[] = new int[]{10000, -10000};
        int r[] = s.sortedSquares(a);
        System.out.println("args = [" + r[1] + "]");
    }
}
