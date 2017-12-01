package com.practice;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/asteroid-collision
 */
public class AsteroidCollision {



    public static void main(String[] args) {

        AsteroidCollision a = new AsteroidCollision();
       /* System.out.println(a.asteroidCollision(new int[]{-2, -1, 1, 2}));
        System.out.println(a.asteroidCollision(new int[]{10, 2, -5}));
        System.out.println(a.asteroidCollision(new int[]{8, -8}));
        System.out.println(a.asteroidCollision(new int[]{5, 10, -5}));*/
        //System.out.println(a.asteroidCollision(new int[]{-5, -10, -5}));
        //System.out.println(a.asteroidCollision(new int[]{5, 10, 5}));
        //System.out.println(a.asteroidCollision(new int[]{-5, 10, -10}));
        //System.out.println(a.asteroidCollision(new int[]{-5, 5, -10, 10}));
        //System.out.println(a.asteroidCollision(new int[]{-5}));
        System.out.println(a.asteroidCollision(new int[]{5}));

    }

    public int[] asteroidCollision(int[] asteroids) {

        List<Integer> sortedAsteroids = new ArrayList<>();
        List<Integer> leftMost = new ArrayList<>();

        for (int i = 0; i < asteroids.length; i++) {
            int v = asteroids[i];

            if(v < 0){
                if(swallowedAll(v, sortedAsteroids)){
                    leftMost.add(v);
                }
            } else {
                sortedAsteroids.add(v);
            }
        }

        leftMost.addAll(sortedAsteroids);
        return convertToIntArray(leftMost);

    }

    private boolean swallowedAll(int v, List<Integer> sortedAsteroids){
        int absV = Math.abs(v);

        int l = sortedAsteroids.size() - 1;

        while(l >= 0 && sortedAsteroids.get(l) < absV){
            sortedAsteroids.remove(l);
            l--;
        }

        if(l >= 0 && sortedAsteroids.get(l) == absV){
            sortedAsteroids.remove(l);
            return false;
        }

        return sortedAsteroids.isEmpty();
    }

    private int[] convertToIntArray(List<Integer> listOfIntegers){
        int [] ints = new int[listOfIntegers.size()];

        for (int i = 0; i < listOfIntegers.size(); i++) {
            int v = listOfIntegers.get(i);

            ints[i] = v;
        }
        return ints;
    }

}
