package com.practice;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/contest/weekly-contest-75/problems/all-paths-from-source-to-target/
 */
public class AllPathsFromSourceToTarget {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> m = new ArrayList<>();
        for (int i = 0; i < graph.length; i++) {
            List<Integer> pathToN = new ArrayList<>();
            paths(i, graph, pathToN);
            m.add(pathToN);
        }

        return m;
    }

    private void paths(int node, int[][] graph, List<Integer> l) {
        int [] neighbors = graph[node];
        for (int neighbor: neighbors) {

            paths(neighbor, graph, l);
        }
    }
}
