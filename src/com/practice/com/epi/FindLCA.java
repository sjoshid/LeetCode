package com.practice.com.epi;

import com.practice.common.BSTNodeWithParent;

import java.util.HashSet;
import java.util.Set;

//13.4 Compute the LCA, optimizing for close ancestors
public class FindLCA {

    public static void main(String[] args) {
        FindLCA l = new FindLCA();
        l.isIncreasingDigitsSequence(1224);
    }

    public BSTNodeWithParent<Integer> findLCA(BSTNodeWithParent<Integer> n1, BSTNodeWithParent<Integer> n2) {
        Set<BSTNodeWithParent<Integer>> visitedNodes = new HashSet<>();

        while (n1 != null || n2 != null) {
            BSTNodeWithParent<Integer> parentOfN1 = n1.getParent();
            BSTNodeWithParent<Integer> parentOfN2 = n2.getParent();

            if (parentOfN1 != null && parentOfN1.equals(parentOfN2)) {
                return parentOfN1;
            }

            if (visitedNodes.contains(parentOfN1)) {
                return parentOfN1;
            }

            if (visitedNodes.contains(parentOfN2)) {
                return parentOfN2;
            }

            visitedNodes.add(parentOfN1);
            visitedNodes.add(parentOfN2);

            n1 = parentOfN1;
            n2 = parentOfN2;
        }

        return null; //invalid
    }

    boolean isIncreasingDigitsSequence(int n) {

        String nStr = Integer.toString(n);
        char[] chars = nStr.toCharArray();
        int p = -1;
        for (char c : chars) {
            int v = c;

            if (v > p) {
                p = v;
                continue;
            }

            return false;
        }
        return true;

    }

}
