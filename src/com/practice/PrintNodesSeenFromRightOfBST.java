package com.practice;

import com.practice.common.BSTNode;

/**
 * https://leetcode.com/problems/binary-tree-right-side-view
 */
public class PrintNodesSeenFromRightOfBST {

    int max;

    public static void main(String[] args) {

        BSTNode<String> root = new BSTNode<>("1");
        BSTNode<String> right = new BSTNode<>("3");
        BSTNode<String> left = new BSTNode<>("2");

        root.setLeft(left);
        root.setRight(right);

        PrintNodesSeenFromRightOfBST p = new PrintNodesSeenFromRightOfBST();
        p.printNodesSeenFromRight(root, 1);
    }

    private void printNodesSeenFromRight(BSTNode<String> node, int i) {

        if (node != null) {
            if (node.getRight() == null && node.getLeft() == null) {
                if (i > max) {
                    System.out.println(node.getValue());
                    max = i;
                }
            } else {
                if (i > max)
                    System.out.println(node.getValue());

                i++;
                printNodesSeenFromRight(node.getRight(), i);
                printNodesSeenFromRight(node.getLeft(), i);
            }
        }
    }
}
