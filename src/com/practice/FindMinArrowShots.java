package com.practice;

import java.util.Arrays;
import java.util.Comparator;

public class FindMinArrowShots {
    public int findMinArrowShots(int[][] points) {
        if (points.length == 0) return 0;
        if (points.length == 1) return 1;
        Arrays.sort(points, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return Integer.compare(o1[0], o2[0]);
            }
        });

        int shotsRequired = 0;

        int[] first = points[0];
        for (int j = 1; j < points.length; j++) {
            int i = j;
            while (i < points.length && overlap(first, points[i])) {
                int greaterOfStarts = Math.max(first[0], points[i][0]);
                int minOfEnds = Math.min(first[1], points[i][1]);
                first[0] = greaterOfStarts;
                first[1] = minOfEnds;
                i++;
            }
            if (i == points.length - 1) {
                shotsRequired++;
            }
            if (i < points.length - 1) {
                first[0] = points[i][0];
                first[1] = points[i][1];
            }
            j = i;
            shotsRequired++;
        }

        return shotsRequired;
    }

    private boolean overlap(int[] i, int[] j) {
        return !(j[1] < i[0] || j[0] > i[1]);
    }

    public static void main(String[] args) {
        /*int [][] points = new int[9][];
        points[0] = new int[]{1,9};
        points[1] = new int[]{7,16};
        points[2] = new int[]{2,5};
        points[3] = new int[]{7,12};
        points[4] = new int[]{9,11};
        points[5] = new int[]{2,10};
        points[6] = new int[]{9,16};
        points[7] = new int[]{3,9};
        points[8] = new int[]{1,3};*/

        int[][] points = new int[4][];
        points[0] = new int[]{1, 1};
        points[1] = new int[]{2, 8};
        points[2] = new int[]{2, 6};
        points[3] = new int[]{7, 12};
        /*points[4] = new int[]{9,11};
        points[5] = new int[]{2,10};
        points[6] = new int[]{9,16};
        points[7] = new int[]{3,9};
        points[8] = new int[]{1,3};*/

        FindMinArrowShots n = new FindMinArrowShots();
        n.findMinArrowShots(points);
    }
}
