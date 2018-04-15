package com.practice;

import com.practice.common.BSTNode;

/**
 * https://leetcode.com/problems/binary-tree-pruning/description/
 */
public class PruneTree {
    public BSTNode<Integer> pruneTree(BSTNode<Integer> root) {

        if(checkPrune(root) == 0) {
            //remove
            root = null;
        } else {
            if(pruneTree(root.left) == null) root.left = null;
            if(pruneTree(root.right) == null) root.right = null;
        }
        return root;
    }

    private int checkPrune(BSTNode<Integer> n) {

        if(n != null) {
            return checkPrune(n.left) + checkPrune(n.right) + n.value;
        } else {
            return 0;
        }
    }

    public static void main(String[] args) {
        PruneTree t = new PruneTree();
        BSTNode<Integer> n1 = new BSTNode<Integer>(0);
        BSTNode<Integer> n2 = new BSTNode<Integer>(0);
        BSTNode<Integer> n3 = new BSTNode<Integer>(1);
        BSTNode<Integer> n4 = new BSTNode<Integer>(1);

        n2.left = n1;
        n2.right = n3;

        n4.right = n2;

        t.pruneTree(n4);
    }
}
