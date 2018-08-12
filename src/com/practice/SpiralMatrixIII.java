package com.practice;

public class SpiralMatrixIII
{
    public int[][] spiralMatrixIII(int R, int C, int r0, int c0)
    {
        int[][] newMatrix = buildSuperMatrix(R, C);
        insert1s(newMatrix, R, C);
        return startTraversing(newMatrix, R, C, R + r0, C + c0);
    }

    private int[][] startTraversing(int[][] newMatrix, int R, int C, int startR, int startC)
    {
        boolean dirFlag = true;
        int ctr = 0;
        int insertInLocation = 0;
        int[][] locations = new int[R * C][];
        while(insertInLocation < locations.length)
        {
            if(putOnlyValid(startR, startC, R, C, newMatrix, locations, insertInLocation))
            {
                insertInLocation++;
            }

            ctr++;
            if(dirFlag)
            {
                //right and below
                dirFlag = false;
                for(int g = startC + 1; g <= startC + ctr; g++)
                {
                    if(putOnlyValid(startR, g, R, C, newMatrix, locations, insertInLocation))
                    {
                        insertInLocation++;
                    }
                }
                startC = startC + ctr;
                for(int h = startR + 1; h <= startR + ctr; h++)
                {
                    if(putOnlyValid(h, startC, R, C, newMatrix, locations, insertInLocation))
                    {
                        insertInLocation++;
                    }
                }
                startR = startR + ctr;
            }
            else
            {
                //left and up
                dirFlag = true;

                for(int g = startC - 1; g >= startC - ctr; g--)
                {
                    if(putOnlyValid(startR, g, R, C, newMatrix, locations, insertInLocation))
                    {
                        insertInLocation++;
                    }
                }
                startC = startC - ctr;
                for(int h = startR - 1; h >= startR - ctr; h--)
                {
                    if(putOnlyValid(h, startC, R, C, newMatrix, locations, insertInLocation))
                    {
                        insertInLocation++;
                    }
                }
                startR = startR + ctr;
            }
        }
        return locations;
    }

    private boolean putOnlyValid(int R, int C, int originalR, int originalC, int[][] newMatrix,
            int[][] locations, int insertLocation)
    {
        boolean isValid = false;
        if(newMatrix[R][C] == 1) //means it's a valid location
        {
            int r = R - originalR;
            int c = C - originalC;
            int[] pos = new int[] { r, c };
            locations[insertLocation] = pos;
            isValid = true;
        }
        return isValid;
    }

    private void insert1s(int[][] newMatrix, int R, int C)
    {
        for(int i = R; i < 2 * R; i++)
        {
            for(int j = C; j < 2 * C; j++)
            {
                newMatrix[i][j] = 1;
            }

        }
    }

    private int[][] buildSuperMatrix(int R, int C)
    {
        int R3 = R * 3;
        int C3 = C * 3;
        int[][] newMatrix = new int[R3][C3];

        for(int i = 0; i < R3; i++)
        {
            for(int j = 0; j < C3; j++)
            {
                newMatrix[i][j] = 0;
            }
        }

        return newMatrix;
    }
}
