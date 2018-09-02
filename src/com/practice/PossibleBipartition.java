package com.practice;

import java.util.*;

public class PossibleBipartition {
    Map<Boolean, Set<Integer>> colors = new HashMap<>();
    Map<Integer, List<Integer>> edges = new HashMap<>();
    boolean sad = false;

    public static void main(String[] args) {
        PossibleBipartition pb = new PossibleBipartition();
        int[][] a = new int[3][];
        a[0] = new int[]{1, 2};
        a[1] = new int[]{1, 3};
        a[2] = new int[]{2, 4};
        pb.possibleBipartition(4, a);
    }

    public boolean possibleBipartition(int N, int[][] dislikes) {
        for (int i = 1; i <= N; i++) {
            edges.put(i, new ArrayList<>());
        }
        edges(dislikes);
        colors.put(true, new HashSet<>());
        colors.put(false, new HashSet<>());
        dfs(dislikes[0][0], true);

        return sad;
    }

    private boolean dfs(Integer edge, Boolean color) {
        List<Integer> currentEdges = edges.get(edge);
        for (int i = 0; i < currentEdges.size(); i++) {
            if (!sad) {
                Integer v = currentEdges.get(i);
                if (colors.get(color).contains(v)) {
                    sad = true;
                    return true;
                } else {
                    Boolean opp = !color;
                    colors.get(opp).add(v);
                    boolean impossible = dfs(v, opp);
                    if (impossible) {
                        break;
                    }
                }
            }
        }
        return false;
    }

    private void edges(int[][] dislikes) {
        for (int i = 0; i < dislikes.length; i++) {
            edges.get(dislikes[i][0]).add(dislikes[i][1]);
            edges.get(dislikes[i][1]).add(dislikes[i][0]);
        }
    }
}
