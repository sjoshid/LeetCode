package com.practice;

public class DegreeOfAnArray {

    public static void main(String[] args) {
        DegreeOfAnArray d = new DegreeOfAnArray();
        int max = d.findShortestSubArray(new int []{2,1,1,2,1,3,3,3,1,3,1,3,2});
        System.out.print(max);
        //random comment
    }

    public int findShortestSubArray(int[] nums) {
        int maxDegree = 0;
        int smallest = 0;
        int [] [] counts = new int [50000][];

        for (int i = 0; i < nums.length; i++) {
            int number = nums[i];



            int [] current = counts[number];

            if (current == null) {
                //first time
                int [] c = new int [3];

                c[0] = 1;
                c[1] = i;
                c[2] = i;

                counts[number] = c;
            } else {
                int [] existing = current;

                int degree = ++existing[0];
                existing[0] = degree;
                existing[2] = i;

                if(degree > maxDegree) {
                    maxDegree = degree;
                    smallest = existing[2] - existing[1];
                } else if (degree == maxDegree) {
                    int currentSmall = existing[2] - existing[1];

                    if (currentSmall < smallest) {
                        smallest = currentSmall;
                    }

                }
            }
        }

        return ++smallest;
    }
}
