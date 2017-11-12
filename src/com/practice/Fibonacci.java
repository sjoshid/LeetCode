package com.practice;

import java.util.HashMap;
import java.util.Map;

public class Fibonacci {

    Map<Integer, Integer> store = new HashMap<>();

    public static void main(String[] args) {
        Fibonacci f = new Fibonacci();
        int s = 10;
        int i = 1;
        System.out.println("Old fib");
        while(i <= s) {
            System.out.println(f.fib(i++));
        }

        System.out.println("Improved fib");
        i = 1;
        while(i <= s) {
            int res = f.fibImproved(i);
            System.out.println(res);
            f.store.put(i++, res);
        }
    }


    private int fib(int n){


        if(n == 0) {
            return 0;
        }
        if(n == 1) {
            return 1;
        }

        return fib(n - 1) + fib(n - 2);
    }

    private int fibImproved(int n){

        if(store.containsKey(n)) {
            return store.get(n);
        } else {
            if(n == 0) {
                return 0;
            }
            if(n == 1) {
                return 1;
            }

            return fibImproved(n - 1) + fib(n - 2);
        }
    }
}
