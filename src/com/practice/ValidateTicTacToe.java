package com.practice;

/**
 * https://leetcode.com/problems/valid-tic-tac-toe-state/description/
 */
public class ValidateTicTacToe {

    int Xcount = 0, Ocount = 0;

    public boolean validTicTacToe(String[] board) {
        int [][] newMap = new int[3][3];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < 3; j++) {
                int v = 0;
                if(board[i].charAt(j) == 'X') {
                    newMap[i][j] = 1;
                    Xcount++;
                } else if (board[i].charAt(j) == 'O') {
                    Ocount++;
                    newMap[i][j] = -1;
                }
            }
        }
        return validate(newMap, Xcount, Ocount);
    }

    private boolean validate(int[][] newMap, int Xcount, int Ocount) {
        int [] results = new int[8];
        results[0] = newMap[0][0] + newMap[0][1] + newMap[0][2];
        results[1] = newMap[0][0] + newMap[1][1] + newMap[2][2];
        results[2] = newMap[0][0] + newMap[1][0] + newMap[2][0];
        results[3] = newMap[0][1] + newMap[1][1] + newMap[2][1];
        results[4] = newMap[0][2] + newMap[1][2] + newMap[2][2];
        results[5] = newMap[0][2] + newMap[1][1] + newMap[2][0];
        results[6] = newMap[1][0] + newMap[1][1] + newMap[1][2];
        results[7] = newMap[2][0] + newMap[2][1] + newMap[2][2];
        boolean aWon = false;
        boolean bWon = false;
        for (int r: results) {

            if(r == 3 && !aWon) {
                aWon = true;
            }
            if(r == -3 && !bWon) {
                bWon = true;
            }
        }

        if(aWon && bWon) return false;

        if(aWon && Xcount != Ocount + 1) {
            return false;
        } else if (bWon && Ocount != Xcount) {
            return false;
        }

        return !(Xcount > Ocount + 1 || Xcount < Ocount);
    }
}