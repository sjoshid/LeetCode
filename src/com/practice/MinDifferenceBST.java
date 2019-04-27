package com.practice;

import com.practice.common.BSTNode;

/**
 * https://leetcode.com/problems/minimum-distance-between-bst-nodes/description/
 */
public class MinDifferenceBST {

    Integer prev;
    Integer min = Integer.MAX_VALUE;

    public int minDiffInBST(BSTNode<Integer> root) {
        minDiff(root);
        return min;
    }

    public void minDiff(BSTNode<Integer> root) {
        if (root != null) {
            minDiff(root.getLeft());
            if (prev == null) {
                prev = root.getValue();
            } else {
                min = Math.min(min, root.getValue() - prev);
                prev = root.getValue();
            }

            minDiff(root.getRight());
        }
    }
}
