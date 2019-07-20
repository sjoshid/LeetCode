package com.practice;

import java.util.HashSet;
import java.util.Set;

public class FindTarget {
    Set<Integer> rems = new HashSet<>();

    public boolean findTarget(TreeNode root, int k) {
        if (root != null) {
            if (!rems.contains(root.val)) {
                rems.add(k - root.val);
                return findTarget(root.left, k) || findTarget(root.right, k);
            } else {
                return true;
            }
        }
        return false;
    }
}
