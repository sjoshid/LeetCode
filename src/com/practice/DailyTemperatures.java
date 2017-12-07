package com.practice;

import java.util.TreeMap;

public class DailyTemperatures {

    public static void main(String[] args) {
        DailyTemperatures dt = new DailyTemperatures();
        //dt.dailyTemperatures(new int[]{73, 74, 75, 71, 69, 72, 76, 73});
        dt.dailyTemperatures(new int[]{1, 2, 3, 4, 5, 6, 7, 8});
        dt.dailyTemperatures(new int[]{3, 2, 1});
        dt.dailyTemperatures(new int[]{89,62,70,58,47,47,46,76,100,70});
    }

    public int[] dailyTemperatures(int[] temperatures) {
        int [] res = new int[temperatures.length];
        res[temperatures.length - 1] = 0;
        TreeMap<Integer, Integer> temps = new TreeMap<>();
        temps.put(temperatures[temperatures.length - 1], temperatures.length - 1);
        //temps.ceilingKey()
        for(int i = temperatures.length - 2; i >= 0 ; i--){
            int temp = temperatures[i];
            //int t = -1;
            Integer t = temps.ceilingKey(temp+1);
            if(t != null){
                int indexGreater = temps.get(t);
                res[i] = indexGreater - i;
                int j = i + 1;
                while(j < indexGreater) {
                    if(temperatures[j] > t){
                        res[i] = j - i;
                        break;
                    }
                    j++;
                }
            } else {
                res[i] = 0;
            }

            temps.put(temp, i);
        }

        return res;
    }
}
