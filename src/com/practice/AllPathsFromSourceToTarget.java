package com.practice;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/contest/weekly-contest-75/problems/all-paths-from-source-to-target/
 */
public class AllPathsFromSourceToTarget {
    List<List<Integer>> m = new ArrayList<>();

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {

        for (int i = 0; i < graph[0].length; i++) {
            List<Integer> pathToN = new ArrayList<>();
            pathToN.add(0);
            paths(graph[0][i], graph, pathToN);
        }

        return m;
    }

    private void paths(int node, int[][] graph, List<Integer> l) {
        List<Integer> nl = new ArrayList<>(l);
        nl.add(node);
        if (node != graph.length - 1) {
            int[] neighbors = graph[node];
            for (int neighbor : neighbors) {
                paths(neighbor, graph, nl);
            }
        } else {
            m.add(nl);
        }
    }
}
