package com.practice;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/minimum-ascii-delete-sum-for-two-strings/description/
 */
public class MinAscii {

    public static void main(String[] args) {

        MinAscii ma = new MinAscii();
        System.out.println(ma.minimumDeleteSum("amtzz", "bmtz"));
    }

    public int minimumDeleteSum(String s1, String s2) {
        String ss1 = sortString(s1);
        String ss2 = sortString(s2);

        if (ss1.equals(ss2)) {
            return 0;
        }

        if (ss1.contains(ss2)) {
            return calMim(ss1, ss2);
        } else if (ss2.contains(ss1)) {
            return calMim(ss2, ss1);
        }

        //ss1.codePointAt();

        return cal(ss1, ss2);
    }

    private int cal(String s1, String s2) {

        int sum = 0;
        int i = 0, j = 0;

        for (; i < s1.length() && j < s2.length(); i++, j++) {
            int c1 = s1.charAt(i);
            int c2 = s2.charAt(j);

            if (c1 != c2) {
                sum += (c1 + c2);
            }
        }

        for (int k = j; k < s2.length(); k++) {
            int c1 = s2.charAt(k);
            sum += c1;
        }

        for (int k = i; k < s1.length(); k++) {
            int c1 = s1.charAt(k);
            sum += c1;
        }

        return sum;
    }

    private int calMim(String bigger, String smaller) {

        int biggerSum = 0;

        for (int c : bigger.toCharArray()) {
            biggerSum += c;
        }

        int smallerSum = 0;

        for (int c : smaller.toCharArray()) {
            smallerSum += c;
        }

        return biggerSum - smallerSum;
    }


    private String sortString(String s) {
        char tempArray[] = s.toCharArray();

        // sort tempArray
        Arrays.sort(tempArray);

        return new String(tempArray);
    }
}
