package com.practice;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * This fails some test cases.
 */
public class TreeFruits {
    public int totalFruit(int[] tree) {
        Set<Integer> uniqTypes = new LinkedHashSet<>(2);
        int totalMax = 0;
        int total = 0;
        for (int i = 0; i < tree.length; i++) {

            int ft = tree[i];

            if(uniqTypes.contains(ft)) {
                total++;
            } else {
                if (uniqTypes.size() < 2) {
                    uniqTypes.add(ft);

                    total++;
                } else {
                    //start over
                    totalMax = Math.max(total, totalMax);
                    Iterator<Integer> itr = uniqTypes.iterator();
                    itr.next(); Integer last = itr.next();
                    uniqTypes.clear();
                    uniqTypes.add(last);
                    uniqTypes.add(ft);
                    total = 2;

                }
            }
        }

        return Math.max(total, totalMax);
    }

    public static void main(String[] args) {
        TreeFruits tf = new TreeFruits();
        int [] lkjaf = new int[]{3,3,3,1,2,1,1,2,3,3,4};
        tf.totalFruit(lkjaf);
    }
}
