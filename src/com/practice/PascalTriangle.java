package com.practice;

import java.util.ArrayList;
import java.util.List;

public class PascalTriangle {
    public List<List<Integer>> generate(int numRows) {
        int i = 0;
        List<List<Integer>> ll = new ArrayList<>();
        while (i < numRows) {
            List<Integer> l = new ArrayList<>(i + 1);
            for (int j = 0; j <= i; j++) {
                Integer a = pascal(i, j, i + 1);
                l.add(a);
            }
            ll.add(l);
            i++;
        }
        return ll;
    }

    Integer pascal(Integer a, Integer b, int layer) {
        if (a == 0 && b == 0) {
            return 1;
        } else if (a < 0 || b == layer) {
            return 0;
        }

        return pascal(a - 1, b - 1, layer - 1) + pascal(a - 1, b, layer - 1);
    }

    public static void main(String[] args) {
        PascalTriangle pt = new PascalTriangle();
        pt.generate(5);
    }
}
