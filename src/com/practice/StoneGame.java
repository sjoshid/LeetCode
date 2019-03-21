package com.practice;

public class StoneGame {
    int cm = 0;

    public boolean stoneGame(int[] piles) {
        String p = "";
        for (int i = 0; i < piles.length; i++) {
            p = p + piles[i];
        }

        int max = Math.max(piles[0], piles[piles.length - 1]);

        if (piles[0] > piles[piles.length - 1]) {
            //right side
        } else if (piles[piles.length - 1] > piles[0]) {
            //left
        } else {

        }
    }

    public static void main(String[] args) {

    }
}
