package com.practice;

import java.util.HashMap;
import java.util.Map;

public class ClimbStairs {
    Map<Integer, Integer> v = new HashMap<>();

    public int climbStairs(int n) {
        if (n == 1) {
            return 1;
        }

        if (n == 2) {
            return 2;
        }

        if (n == 0) {
            return 0;
        }

        if (v.containsKey(n)) {
            return v.get(n);
        }
        int r = climbStairs(n - 1) + climbStairs(n - 2);
        v.put(n, r);
        return r;
    }

    public static void main(String[] args) {
        ClimbStairs d = new ClimbStairs();
        System.out.println(d.climbStairs(7));
    }
}
