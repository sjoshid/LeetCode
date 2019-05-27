package com.practice.bloomberg;

import java.util.ArrayDeque;
import java.util.Deque;

public class FindCircleNum {
    public int findCircleNum(int[][] M) {
        Deque<Integer> d = new ArrayDeque<>();
        d.addLast(0);
        int nc = 1;
        boolean[] circle = findCircles(M, d);
        for (int i = 0; i < circle.length; i++) {
            if (!circle[i]) {
                nc++;
                d.addLast(i);
                boolean[] newCircle = findCircles(M, d);

                for (int j = 0; j < newCircle.length; j++) {
                    if (newCircle[j]) {
                        circle[j] = true;
                    }
                }
            }
        }
        return nc;
    }

    private boolean[] findCircles(int[][] M, Deque<Integer> d) {
        boolean[] visited = new boolean[M.length];

        while (!d.isEmpty()) {
            Integer i = d.removeFirst();
            visited[i] = true;

            int[] l = M[i];

            for (int j = 0; j < l.length; j++) {
                if (j != i && !d.contains(j) && l[j] == 1 && !visited[j]) {
                    d.addLast(j);
                }
            }
        }
        return visited;
    }
}
