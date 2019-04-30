package com.practice;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

public class ZigzagLevelOrder {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if(root == null) return new ArrayList<>();
        boolean flip = true;
        List<TreeNode> parentBucket = new ArrayList<>();
        parentBucket.add(root);
        List<Integer> values = new ArrayList<>();
        values.add(root.val);

        List<TreeNode> childrenBucket = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
        ans.add(values);
        while(!parentBucket.isEmpty()) {
            values = new ArrayList<>();
            if(flip) {
                while (!parentBucket.isEmpty()) {
                    TreeNode p = parentBucket.remove(parentBucket.size() - 1);
                    TreeNode l = p.left;
                    TreeNode r = p.right;
                    if(r != null) {
                        childrenBucket.add(r);
                        values.add(r.val);
                    }
                    if(l != null) {
                        values.add(l.val);
                        childrenBucket.add(l);
                    }
                }
            } else {
                while (!parentBucket.isEmpty()) {
                    TreeNode p = parentBucket.remove(parentBucket.size() - 1);
                    TreeNode l = p.left;
                    TreeNode r = p.right;
                    if(l != null) {
                        values.add(l.val);
                        childrenBucket.add(l);
                    }
                    if(r != null) {
                        values.add(r.val);
                        childrenBucket.add(r);
                    }
                }
            }
            if(!values.isEmpty())
                ans.add(values);
            parentBucket = new ArrayList<>(childrenBucket);
            childrenBucket.clear();
            flip = !flip;
        }
        return ans;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode w = new TreeNode(9);
        TreeNode e = new TreeNode(20);
        TreeNode r = new TreeNode(15);
        TreeNode t = new TreeNode(7);
        root.left = w;
        w.left = e;
        e.left = r;
        r.left = t;

        ZigzagLevelOrder z = new ZigzagLevelOrder();
        z.zigzagLevelOrder(root);
    }
}
