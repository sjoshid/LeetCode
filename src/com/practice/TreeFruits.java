package com.practice;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * This fails some test cases.
 * WORST Problem I have faced so far. Ugh!!
 */
public class TreeFruits {
    public int totalFruit(int[] tree) {
        Map<Integer, Integer> uniq = new LinkedHashMap<>();
        int totalMax = 0;
        for (int i = 0; i < tree.length; i++) {

            int ft = tree[i];

            if (uniq.containsKey(ft)) {
                Integer v = uniq.get(ft);
                Integer incr = v + 1;
                uniq.put(ft, incr);
            } else {
                if (uniq.size() < 2) {
                    uniq.put(ft, 1);
                } else {
                    Collection<Integer> vs = uniq.values();
                    Iterator<Integer> itr = vs.iterator();
                    Integer ct = 0;
                    while (itr.hasNext()) {
                        ct += itr.next();
                    }
                    //start over
                    totalMax = Math.max(ct, totalMax);
                    Integer keyNeed = tree[i - 1];
                    Integer valueNeed = uniq.get(keyNeed);
                    uniq = new LinkedHashMap<>();
                    uniq.put(keyNeed, 1);
                    uniq.put(ft, 1);

                }
            }
        }

        Collection<Integer> vs = uniq.values();
        Iterator<Integer> itr = vs.iterator();
        Integer ct = 0;
        while (itr.hasNext()) {
            ct += itr.next();
        }
        return Math.max(ct, totalMax);
    }

    public static void main(String[] args) {
        TreeFruits tf = new TreeFruits();
        int[] lkjaf = new int[]{0, 1, 6, 6, 4, 4, 6};
        tf.totalFruit(lkjaf);
    }
}
