package com.practice;

public class DiameterOfBinaryTree {
    int cmax;

    public int diameterOfBinaryTree(TreeNode root) {
        setMins(root);
        diameter(root);
        return cmax;
    }

    private void diameter(TreeNode tn) {
        int lc = -1, rc = -1;
        if (tn != null) {
            if (tn.left != null) {
                if (tn.left.val != Integer.MIN_VALUE) {
                    lc = tn.left.val;
                } else {
                    lc = deepest(tn.left);
                }
            }

            if (tn.right != null) {
                if (tn.right.val != Integer.MIN_VALUE) {
                    rc = tn.right.val;
                } else {
                    rc = deepest(tn.right);
                }
            }

            int max = lc + rc + 2;
            cmax = Math.max(max, cmax);
            diameter(tn.left);
            diameter(tn.right);
        }
    }

    private int deepest(TreeNode tn) {
        if (tn == null) return -1;
        int dl = deepest(tn.left);
        int dr = deepest(tn.right);
        int max = Math.max(dl, dr);
        tn.val = ++max;
        return tn.val;
    }

    private void setMins(TreeNode tn) {
        if (tn != null) {
            tn.val = Integer.MIN_VALUE;
            setMins(tn.left);
            setMins(tn.right);
        }
    }
}
