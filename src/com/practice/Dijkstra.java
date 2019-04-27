package com.practice;

import java.util.*;

/**
 * //https://www.hackerrank.com/challenges/dijkstrashortreach/problem
 */
public class Dijkstra {

    public static void main(String[] args) {

        Dijkstra dj = new Dijkstra();
        dj.startTestCases();
    }


    public void startTestCases() {

        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int a0 = 0; a0 < t; a0++) {
            int n = in.nextInt();
            Node[] nodes = new Node[n + 1];

            int m = in.nextInt();
            for (int a1 = 0; a1 < m; a1++) {
                int x = in.nextInt();
                Node existing = nodes[x];
                Node n1 = null;
                if (existing != null) {
                    n1 = existing;
                } else {
                    n1 = new Node(x);
                    nodes[x] = n1;
                }

                int y = in.nextInt();
                Node existing2 = nodes[y];
                Node n2 = null;
                if (existing2 != null) {
                    n2 = existing2;
                } else {
                    n2 = new Node(y);
                    nodes[y] = n2;
                }

                int r = in.nextInt();
                n1.addNeighbor(n2, r);
                n2.addNeighbor(n1, r);
            }
            int s = in.nextInt();
            Node starting = nodes[s];
            starting.cd = 0;
            Set<Node> visitedNodes = new LinkedHashSet<>();
            visitedNodes.add(starting);

            Queue<Node> tobeVisited = new LinkedList<>();
            tobeVisited.add(starting);

            while (!tobeVisited.isEmpty()) {
                Node head = tobeVisited.poll();
                shortestPath(head, tobeVisited, visitedNodes);
            }

            for (int k = 1; k < nodes.length; k++) {
                if (k != s) {
                    System.out.print(nodes[k].cd + " ");
                }
            }
        }
    }

    public void shortestPath(Node n, Queue<Node> tobeVisited, Set<Node> visitedNodes) {

        for (Map.Entry<Node, Integer> neighborEntry : n.neighbors.entrySet()) {

            Node neighbor = neighborEntry.getKey();
            Integer w = neighborEntry.getValue();

            int d = n.cd + w;
            neighbor.cd = Math.min(d, neighbor.cd);

            if (!visitedNodes.contains(neighbor)) {

                tobeVisited.add(neighbor);
            }
        }

        visitedNodes.add(n);
    }

    class Node {

        int id;
        int cd = Integer.MAX_VALUE;
        Map<Node, Integer> neighbors = new HashMap<>();

        Node(int id) {
            this.id = id;
        }

        public void addNeighbor(Node neighbor, Integer weight) {
            neighbors.put(neighbor, weight);
        }
    }

}
