package com.practice;

public class IsValidBST {
    public boolean isValidBST(TreeNode root) {
        return traverseTree(root, null, null);
    }

    private boolean traverseTree(TreeNode n, Integer lower, Integer upper) {
        if (n == null) return true;

        int v = n.val;

        if (lower != null && v < lower) return false;
        if (upper != null && v > upper) return false;

        if (!traverseTree(n.left, lower, v)) return false;
        if (!traverseTree(n.right, v, upper)) return false;
        return true;
    }
}
